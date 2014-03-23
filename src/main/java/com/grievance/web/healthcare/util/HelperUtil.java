package com.grievance.web.healthcare.util;

import java.util.Map;

import com.grievance.web.healthcare.controller.ProfileController;

public class HelperUtil {

	private Map<Integer, String> months;
	
	private Map<Integer, Integer> days;
	
	private Map<String, String>  states;
	
	private Integer minimumAgeForRegistration;
	
	public HelperUtil() {

	}
	
	public Map<Integer, String> getMonths() {
		return months;
	}

	public Map<Integer, Integer> getDays() {
		return days;
	}

	public void setMonths(Map<Integer, String> months) {
		this.months = months;
	}

	public void setDays(Map<Integer, Integer> days) {
		this.days = days;
	}
	
	public Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		this.states = states;
	}

	public Integer getMinimumAgeForRegistration() {
		return minimumAgeForRegistration;
	}

	public void setMinimumAgeForRegistration(Integer minimumAgeForRegistration) {
		this.minimumAgeForRegistration = minimumAgeForRegistration;
	}
	
}
