package com.grievance.web.healthcare.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Properties;

@Component
public class RegularExpressionViewHelper implements ServletContextAware {

    private ServletContext servletContext;
    
    @Qualifier("regularExpression")
    private Properties regularExpression;

    @Autowired
    public void setRegularExpression(Properties regularExpression) {
        this.regularExpression = regularExpression;
    }
   
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        if (this.servletContext != null) {
            initializeRegularExpressions();
        }
    }
    
    private void initializeRegularExpressions() {

        try {
            this.name = regularExpression
                    .getProperty(REGULAR_EXPRESSION.NAME_REGULAR_EXPRESSION
                            .name());
            this.email = regularExpression
                    .getProperty(REGULAR_EXPRESSION.EMAIL_REGULAR_EXPRESSION
                            .name());
            this.address = regularExpression
                    .getProperty(REGULAR_EXPRESSION.ADDRESS_REGULAR_EXPRESSION
                            .name());
            this.city = regularExpression
                    .getProperty(REGULAR_EXPRESSION.CITY_REGULAR_EXPRESSION
                            .name());
            this.zipCode = regularExpression
                    .getProperty(REGULAR_EXPRESSION.ZIPCODE_REGULAR_EXPRESSION
                            .name());
            this.phone = regularExpression
                    .getProperty(REGULAR_EXPRESSION.PHONE_REGULAR_EXPRESSION
                            .name());
            this.numeric = regularExpression
                    .getProperty(REGULAR_EXPRESSION.NUMERIC_REGULAR_EXPRESSION
                            .name());
            this.password = regularExpression
                    .getProperty(REGULAR_EXPRESSION.PASSWORD_REGULAR_EXPRESSION
                            .name());
            this.lastname = regularExpression
            .getProperty(REGULAR_EXPRESSION.LASTNAME_REGULAR_EXPRESSION
                    .name());
         } catch (Exception e) {
            e.printStackTrace(); 
        }

    }
    
    private String name;
    
    private String lastname;
    
    private String email;
    
    private String address;
    
    private String city;
    
    private String zipCode;
    
    private String phone;
    
    private String numeric;
    
    private String password;
    
    public enum REGULAR_EXPRESSION {
        EMAIL_REGULAR_EXPRESSION, NAME_REGULAR_EXPRESSION, ADDRESS_REGULAR_EXPRESSION, CITY_REGULAR_EXPRESSION,
        ZIPCODE_REGULAR_EXPRESSION, PHONE_REGULAR_EXPRESSION, NUMERIC_REGULAR_EXPRESSION,
        PASSWORD_REGULAR_EXPRESSION, ATTENTION_REGULAR_EXPRESSION, LASTNAME_REGULAR_EXPRESSION, LOYALTYNUMBER_REGULAR_EXPRESSION, 
        ORDEERNUMBER_REGULAR_EXPRESSION,LOOKUP_EMAIL_REGULAR_EXPRESSION,ACCOUNT_ATTENTION_REGULAR_EXPRESSION
    }
    
    public String getName() {
        return name;
    }
   
	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		System.out.println("Email:"+email);
        return email;
    }
	
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getNumeric() {
        return numeric;
    }

    public String getPassword() {
        return password;
    }
    
    
}
