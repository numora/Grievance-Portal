package com.grievance.web.healthcare.beans.common;

public class Address extends BaseBean {

	private static final long serialVersionUID = 726095313537907831L;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String postalCode;

	private String state;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
		builder.append("Address [addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine1);
		builder.append(", city=");
		builder.append(city);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append("]");
		return builder.toString();
	}

}
