package com.grievance.web.healthcare.beans.common;

public class Phone extends BaseBean {

	private static final long serialVersionUID = -2695503517581660871L;

	private String areaCode;
	
	private String exchangeNumber;
	
	private String subscriberNumber;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getExchangeNumber() {
		return exchangeNumber;
	}

	public void setExchangeNumber(String exchangeNumber) {
		this.exchangeNumber = exchangeNumber;
	}

	public String getSubscriberNumber() {
		return subscriberNumber;
	}

	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [areaCode=");
		builder.append(areaCode);
		builder.append(", exchangeNumber=");
		builder.append(exchangeNumber);
		builder.append(", subscriberNumber=");
		builder.append(subscriberNumber);
		builder.append("]");
		return builder.toString();
	}

}
