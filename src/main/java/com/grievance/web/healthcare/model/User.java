package com.grievance.web.healthcare.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="user")
@NamedQuery(name="user.findByLoginName", query="from User where loginname = :name and password = :password")
public class User {
	
		private Long id;
		
		private String password;
		
		private String loginname;
		
		private String encryptedPassword;
		
		private String emailAddress;
		
		private Boolean verified;
		
		private Date lastAccessTime;
		
		private Calendar registrationDate;
		

		@Column(name="login_name")
		public String getLoginname() {
			return loginname;
		}

		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}

		@Id
		@GeneratedValue
		@Column(name="id")
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		@Column(name="password")
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Transient
		public String getEncryptedPassword() {
			return encryptedPassword;
		}

		public void setEncryptedPassword(String encryptedPassword) {
			this.encryptedPassword = encryptedPassword;
		}

		
		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		@Basic
		public Boolean getVerified() {
			return verified;
		}

		public void setVerified(Boolean verified) {
			this.verified = verified;
		}

		@Temporal(TemporalType.TIMESTAMP)
		public Date getLastAccessTime() {
			return lastAccessTime;
		}

		public void setLastAccessTime(Date lastAccessTime) {
			this.lastAccessTime = lastAccessTime;
		}

		@Temporal(TemporalType.DATE)
		public Calendar getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(Calendar registrationDate) {
			this.registrationDate = registrationDate;
		}
		
		public String toString() {
			
			String tmpStr = "[ID " + id + " | Login name " + loginname;
			
			tmpStr += " | password " + password;
			
			tmpStr += " | email " + emailAddress + "]";
			
			return tmpStr;
			
		}
}
