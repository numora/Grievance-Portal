/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grievance.web.healthcare.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

 

public class SignInHelper {
  private static final String api_key = "1579187898972522";     
    private static final String secret = "823803e8600ad6dc9ec5edde7af83911";
    private static final String client_id = "1579187898972522";   
 
    // set this to your servlet URL for the authentication servlet/filter
    private static final String redirect_uri = "http://localhost:8080/Grievance-Portal/grievance/signin/faceBookSignIn"; 
    /// set this to the list of extended permissions you want
    private static final String perms =  "publish_stream,email" ;
    
    public static String getAPIKey() {
        return api_key;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id=" + 
            client_id + "&display=page&redirect_uri=" + 
            redirect_uri+"&scope="+ perms;
    }

    public static String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" + 
            client_id+"&redirect_uri=" + 
            redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
   

}
