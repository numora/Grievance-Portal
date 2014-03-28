package com.grievance.web.healthcare.newmodel;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	private Integer address_id;
	private String address_line_1;
	private String address_line_2;
	private String state;
	private String city;
	private String zip;
	private String po_box;
	
	
	@Id
	@Column(name = "address_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	
	@Column(name = "address_line_1")
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	
	@Column(name = "address_line_2")
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Column(name = "po_box")
	public String getPo_box() {
		return po_box;
	}
	public void setPo_box(String po_box) {
		this.po_box = po_box;
	}
	
	public String toString(){
		return "address_id: "+address_id+"address_line_1: "+address_line_1+"address_line_2: "+address_line_2+
			"zip: "+zip+"city: "+city+"state: "+state;
				
	}
	
}


