package com.grievance.web.healthcare.newmodel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Providers")
public class Providers {
	
	private Integer provider_id;
	private String provier_name;
	private String provider_speciality;
	private Integer provider_type;
	
	@Id
	@Column(name = "provider_id", unique = true, nullable = false)
	public Integer getPprovider_id() {
		return provider_id;
	}
	public void setProvider_id(Integer provider_id) {
		this.provider_id = provider_id;
	}
	
	@Column(name = "provier_name")
	public String getProvier_name() {
		return provier_name;
	}
	public void setProvier_name(String provier_name) {
		this.provier_name = provier_name;
	}
	
	@Column(name = "provider_speciality")
	public String getProvider_speciality() {
		return provider_speciality;
	}
	public void setProvider_speciality(String provider_speciality) {
		this.provider_speciality = provider_speciality;
	}
	
	@Column(name = "provider_type")
	public Integer getProvider_type() {
		return provider_type;
	}
	public void setProvider_type(Integer provider_type) {
		this.provider_type = provider_type;
	}
	
	
}


