package com.grievance.web.healthcare.viewbean;

import java.util.Map;

public class BaseVB  {

	private Map<String, String> states;
	private int signedIn;

	public Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		this.states = states;
	}

	public int getSignedIn() {
		return signedIn;
	}

	public void setSignedIn(int signedIn) {
		this.signedIn = signedIn;
	}
	
}
