package com.grievance.web.healthcare.beans.common;

public class Contact extends BaseBean {

    private static final long serialVersionUID = -2704652340146335740L;

    private String firstName;
    
    private String lastName;
    
    private String middleName;
    
    private Address address;
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Contact [firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", middleName=");
        builder.append(middleName);
        builder.append(", address=");
        builder.append(address);
        builder.append("]");
        return builder.toString();
    }
}
