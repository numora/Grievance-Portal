package com.grievance.web.healthcare.constants;

import java.io.Serializable;

public enum GenderEnum implements Serializable{

	M("Male"), F("Female");

	private String description;

	private GenderEnum(String description) {
		this.description = description;
	}

	public String getValue() {
		return name();
	}

	public void setValue(String value) {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
