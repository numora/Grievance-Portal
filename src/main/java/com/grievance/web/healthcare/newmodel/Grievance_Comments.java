package com.grievance.web.healthcare.newmodel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grievance_comments")
public class Grievance_Comments {
	
	private Integer grievance_comment_Id;
	private CompoundKey_Grevance_Comments compoundKey;
	
	@Id
	@Column(name = "grievance_comment_Id", unique = true, nullable = false)
	public Integer getGrievance_comment_Id() {
		return grievance_comment_Id;
	}
	public void setGrievance_comment_Id(Integer grievance_comment_Id) {
		this.grievance_comment_Id = grievance_comment_Id;
	}
	
	public CompoundKey_Grevance_Comments getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey_Grevance_Comments compoundKey) {
		this.compoundKey = compoundKey;
	}
	
	
	
}


