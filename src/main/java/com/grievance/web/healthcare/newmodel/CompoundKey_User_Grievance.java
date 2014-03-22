package com.grievance.web.healthcare.newmodel;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Embeddable
public class CompoundKey_User_Grievance implements Serializable {
	
	private Grievance grievance;
	public Grievance getGrievance() {
		return grievance;
	}
	public void setGrievance(Grievance grievance) {
		this.grievance = grievance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private User user;
	
	
}


