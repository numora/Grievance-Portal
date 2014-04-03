package com.grievance.web.healthcare.newmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	private int member_id;
	private String first_name;
	private String last_name;
	private String middle_initial;
	private String suffix;
	private long phone;
	private Address address;
	private long address_id;
	private long provider_id;

	@Id
	@Column(name = "member_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column(name = "last_name", nullable = false)
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(name = "middle_initial", nullable = false)
	public String getMiddle_initial() {
		return middle_initial;
	}

	public void setMiddle_initial(String middle_initial) {
		this.middle_initial = middle_initial;
	}

	@Column(name = "suffix", nullable = false)
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name = "phone", nullable = false)
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Column(name = "address_id", nullable = false)
	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	@Column(name = "provider_id", nullable = false)
	public long getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(long provider_id) {
		this.provider_id = provider_id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
