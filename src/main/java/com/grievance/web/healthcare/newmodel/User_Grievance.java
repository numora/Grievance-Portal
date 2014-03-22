package com.grievance.web.healthcare.newmodel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_grievance")
public class User_Grievance {
	
	private Integer user_grievance_Id;
	private CompoundKey_User_Grievance compoundKey;
	
	@Id
	@Column(name = "user_grievance_Id", unique = true, nullable = false)
	public Integer getUser_grievance_Id() {
		return user_grievance_Id;
	}
	public void setUser_grievance_Id(Integer user_grievance_Id) {
		this.user_grievance_Id = user_grievance_Id;
	}
	
	public CompoundKey_User_Grievance getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey_User_Grievance compoundKey) {
		this.compoundKey = compoundKey;
	}
	

	
	
	
	
}


