package com.grievance.web.healthcare.controller;

import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.viewbean.ProfileVB;
import com.grievance.web.healthcare.viewbean.SignInVB;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.bean.validators.ProfileVBValidator;
import com.grievance.web.healthcare.bean.validators.SignInVBValidator;
import com.grievance.web.healthcare.constants.CommonConstants.Action;

import static com.grievance.web.healthcare.constants.CommonConstants.SIGN_IN_MODEL_ATTRIBUTE_NAME;
import com.grievance.web.healthcare.helper.SignInHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import org.openid4java.OpenIDException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signin")
public class SignInController extends BaseController {

    static final Logger logger = LoggerFactory
            .getLogger(SignInController.class);

    public static final String VIEW_NAME = "signin";

    public static final String MODEL_ATTRIBUTE_NAME = "signInVB";
    private ConsumerManager manager;
    public String getViewName() {
        return VIEW_NAME;
    }

    @Autowired
    private SignInVBValidator signInValidator;

    @Autowired
    private UserManager userManager;

    @ModelAttribute(MODEL_ATTRIBUTE_NAME)
    public SignInVB buildModel() {
        return new SignInVB();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupSignInForm(
            @ModelAttribute(MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("In Sign in Controller");
        return getFormView(Action.SignIn);
    }

    @RequestMapping(params = "processSignIn", method = RequestMethod.POST)
    public String processSignIn(
            @ModelAttribute(SIGN_IN_MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            BindingResult result, HttpServletRequest request,
            HttpServletResponse response) throws GenericException {

        logger.debug("In Process Signin ");
        ProfileVB profileVB = null;
        System.out.print("Process Signin" + signInVB.getLoginName());
        signInValidator.validatePortalVB(signInVB, result);
        request.getSession(true).setAttribute("signedIn", 0);
        if (result.hasErrors()) {
            System.out.print("Errors");
            return getFormView(Action.SignIn);
        }

        try {
            profileVB = userManager.getUserDetails(signInVB.getLoginName(),
                    signInVB.getPassword());
            if (profileVB != null) {
                System.out.println("User Successfully Logined"
                        + profileVB.getLastName());
                request.getSession(true).setAttribute("signedIn", 1);
                signInVB.setSignedIn((Integer) request.getSession()
                        .getAttribute("signedIn"));
                return getFormView(Action.GrievanceHome);
            }
            if (profileVB == null) {

            }
        } catch (Exception ex) {
            request.getSession(true).setAttribute("signedIn", 0);
            throw new GenericException(
                    "Exception occurred while processing authenticateUser in SignInController",
                    ex);
        }
        return getFormView(Action.SignIn);
    }

    @RequestMapping(params = "openIdSignIn")
    public String openIdSignIn(
            @ModelAttribute(SIGN_IN_MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            BindingResult result, HttpServletRequest request,
            HttpServletResponse response) throws GenericException, IOException {

        logger.debug("In openIdSignIn ");
         this.manager = new ConsumerManager();
        
        logger.debug("------------------------");
        String identifier = request.getParameter("identifier");
        this.authRequest(identifier, request, response);
        
         return getFormView(Action.SignIn);

    }
     // --- processing the authentication response ---
    public Identifier verifyResponse(HttpServletRequest httpReq) {
        try {
            
            // extract the parameters from the authentication response
            // (which comes in as a HTTP request from the OpenID provider)
            ParameterList response = new ParameterList(
                    httpReq.getParameterMap());
 
            // retrieve the previously stored discovery information
            DiscoveryInformation discovered = (DiscoveryInformation) httpReq
                    .getSession().getAttribute("openid-disc");
 
            // extract the receiving URL from the HTTP request
            StringBuffer receivingURL = httpReq.getRequestURL();
            String queryString = httpReq.getQueryString();
            if (queryString != null && queryString.length() > 0)
                receivingURL.append("?").append(httpReq.getQueryString());
 
            // verify the response; ConsumerManager needs to be the same
            // (static) instance used to place the authentication request
            VerificationResult verification = manager.verify(
                    receivingURL.toString(), response, discovered);
 
            // examine the verification result and extract the verified
            // identifier
            Identifier verified = verification.getVerifiedId();
            if (verified != null) {
                AuthSuccess authSuccess = (AuthSuccess) verification
                        .getAuthResponse();
 
                if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
                    FetchResponse fetchResp = (FetchResponse) authSuccess
                            .getExtension(AxMessage.OPENID_NS_AX);
 
                    List emails = fetchResp.getAttributeValues("email");
                    String email = (String) emails.get(0);
                    logger.info("OpenIdlogin done with email: " + email);
                }
 
                return verified; // success
            }
        } catch (OpenIDException e) {
            // present error to the user
        }
 
        return null;
    }

    private String authRequest(String userSuppliedString, HttpServletRequest httpReq, HttpServletResponse httpResp) throws IOException {
          try {
                String GOOGLE_ENDPOINT = "https://www.google.com/accounts/o8/id";
                String YAHOO_ENDPOINT = "https://me.yahoo.com";
            // configure the return_to URL where your application will receive
            // the authentication responses from the OpenID provider
           
              httpReq.getRequestURL().append("?homepage=homepage");
               String returnToUrl = "http://localhost:8080/Grievance-Portal/grievance/signin?homepage=homepage";
            // --- Forward proxy setup (only if needed) ---
            // ProxyProperties proxyProps = new ProxyProperties();
            // proxyProps.setProxyName("proxy.example.com");
            // proxyProps.setProxyPort(8080);
            // HttpClientFactory.setProxyProperties(proxyProps);
 
            // perform discovery on the user-supplied identifier
            List discoveries = manager.discover(userSuppliedString);
 
            // attempt to associate with the OpenID provider
            // and retrieve one service endpoint for authentication
            DiscoveryInformation discovered = manager.associate(discoveries);
 
            // store the discovery information in the user's session
            httpReq.getSession().setAttribute("openid-disc", discovered);
 
            // obtain a AuthRequest message to be sent to the OpenID provider
            AuthRequest authReq = manager.authenticate(discovered, returnToUrl);
 
            FetchRequest fetch = FetchRequest.createFetchRequest();
            if (userSuppliedString.startsWith(GOOGLE_ENDPOINT)) {
                fetch.addAttribute("email",
                        "http://axschema.org/contact/email", true);
                fetch.addAttribute("firstName",
                        "http://axschema.org/namePerson/first", true);
                fetch.addAttribute("lastName",
                        "http://axschema.org/namePerson/last", true);
            } else if (userSuppliedString.startsWith(YAHOO_ENDPOINT)) {
                fetch.addAttribute("email",
                        "http://axschema.org/contact/email", true);
                fetch.addAttribute("fullname",
                        "http://axschema.org/namePerson", true);
            } else { // works for myOpenID
                fetch.addAttribute("fullname",
                        "http://schema.openid.net/namePerson", true);
                fetch.addAttribute("email",
                        "http://schema.openid.net/contact/email", true);
            }
 
            // attach the extension to the authentication request
            authReq.addExtension(fetch);
 
             httpResp.sendRedirect(authReq.getDestinationUrl(true));
 
        } catch (OpenIDException e) {
            // present error to the user
        }
 
        return null;
    }
 @RequestMapping(params = "homepage")
    public String homePage(
            @ModelAttribute(MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("In Sign in Controller");
       Identifier identif = this.verifyResponse(request);
        logger.debug("identifier: " + identif);
        if (identif != null) {
            return getFormView(Action.GrievanceHome);
        }
        return null;
    }
     @RequestMapping(params = "home")
    public String returnHome(
            @ModelAttribute(MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("In Sign in Controller");
      
            return getFormView(Action.GrievanceHome);
         
        
    }
      @RequestMapping("/faceBookSignIn")
    public String faceBookSignIn(
            @ModelAttribute(SIGN_IN_MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
              HttpServletRequest request,
            HttpServletResponse response) throws GenericException, IOException {

        logger.debug("In openIdSignIn ");
        String code = request.getParameter("code");
        if (code!= null && code.length() >0) {
           String authURL = SignInHelper.getAuthURL(code); 
        URL url = new URL(authURL);
            try {
               String result =readURL(url);
                String accessToken = null;
                Integer expires = null;
                String[] pairs = result.split("&");
                for (String pair : pairs) {
                    String[] kv = pair.split("=");
                    if (kv.length != 2) {
                        throw new RuntimeException("Unexpected auth response");
                    } else {
                        if (kv[0].equals("access_token")) {
                            accessToken = kv[1];
                        }
                        if (kv[0].equals("expires")) {
                            expires = Integer.valueOf(kv[1]);
                        }
                    }
                }
                if (accessToken != null && expires != null) {
                   
                     authFacebookLogin(accessToken, expires);
                      String returnToUrl = "http://localhost:8080/Grievance-Portal/grievance/signin?home=home";
                 response.sendRedirect(returnToUrl);
                } else {
                    throw new RuntimeException("Access token and expires not found");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }       
         return getFormView(Action.SignIn);

    } 
     public String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }
    public void authFacebookLogin(String accessToken, int expires) {
        try {
            
            JSONObject resp = new JSONObject(
                IOUtils.toString(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));
            String id = resp.getString("id");
            String firstName = resp.getString("first_name");
            String lastName = resp.getString("last_name");
            String email = resp.getString("email");

            // ...
            // create and authorise the user in your current system w/ data above
            // ...

        } catch (Throwable ex) {
            throw new RuntimeException("failed login", ex);
        }
    } 
    
}
