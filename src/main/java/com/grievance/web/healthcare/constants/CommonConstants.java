package com.grievance.web.healthcare.constants;

public interface CommonConstants {

	// Model Attributes
	String SIGN_IN_MODEL_ATTRIBUTE_NAME = "signInVB";
	String PROFILE_MODEL_ATTRIBUTE_NAME = "profileVB";
	
	
	// Sign In Constants
    String AUTHENTICATE_USER = "processSignIn";
    
    String ADD_LOYALTY_ACCOUNT_EVENT = "ltyaccountassociation";
    String PLACE_ORDER_EVENT = "placeOrder";
    String SAVE_PROFILE_EVENT = "saveprofile";
    String SAVE_LOYALTY_EMAIL = "saveloyaltyemail";
    
    String FORM_VIEW_SUFFIX = "FormView";
    String REDIRECT_VIEW_SUFFIX="RedirectView";
    
    String NULL_VALUE = "null";
    String CM_CODE = ".cmcode";
    
    public enum Action {
		Home,
		SignIn,
		Success,
		Registration,
		CreateProfile,
		EditAccount,
		ViewAccount,
		ResetPassword;
		
		public String formView() {
			return (new StringBuilder()).append(this.name()).append(
					FORM_VIEW_SUFFIX).toString();
		}

		public String redirectView() {
			return (new StringBuilder()).append(this.name()).append(
					REDIRECT_VIEW_SUFFIX).toString();
		}
		
	}
    
}
