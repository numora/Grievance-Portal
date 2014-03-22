package com.grievance.web.healthcare.newmodel;



import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompoundKey_Grevance_Comments implements Serializable {
	
	private Grievance  user;
	private Comment comments;
	
	public Grievance getUser() {
		return user;
	}
	public void setUser(Grievance user) {
		this.user = user;
	}
	
	public Comment getComments() {
		return comments;
	}
	public void setComments(Comment comments) {
		this.comments = comments;
	}
	
	
}


