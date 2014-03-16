/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grievance.web.healthcare.viewbean;

import java.io.File;

/**
 *
 * @author sabbani
 */
public class RegistrationTO {

    private Long regId;
    //member address
    private String memberStreet;
    private String memberCity;
    private String memberAState;
    private String memberzZipcode;
    private String memberPhone;
    //member personal info
    private String memberFirstName;
    private String memberLastName;
    private String memberMiddleInitail;
    private String memberSuffix;
    private String memberProviderType;
    private String memberProviderSpeciality;
    private String memberDateOfBirth;
    // federal basic info
    private String federalFirstName;
    private String federalLastName;
    private String federalMiddleInitail;
    private String federalSuffix;
    private String federalProviderType;
    private String federalProviderSpeciality;
    private String federalDateOfBirth;
    // federal address
    private String federalStreet;
    private String federalCity;
    private String federalAState;
    private String federalzZipcode;
    private Long federalPhone;
    // license info
    private String licenseType;
    private String licenseNum;
    private String expiryDate;
    //member Identifiers
    private String npi;
    private String taxId;
    //member exclusion
    private String exclusionsCode;
    private String exclusionsDesc;
    private String exclusionsDate;
    //federal
    private String providerSpecialty;
    private String taxonomy;
    private File attachedFile;

    public File getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(File attachedFile) {
        this.attachedFile = attachedFile;
    }

    public String getExclusionsCode() {
        return exclusionsCode;
    }

    public void setExclusionsCode(String exclusionsCode) {
        this.exclusionsCode = exclusionsCode;
    }

    public String getExclusionsDate() {
        return exclusionsDate;
    }

    public void setExclusionsDate(String exclusionsDate) {
        this.exclusionsDate = exclusionsDate;
    }

    public String getExclusionsDesc() {
        return exclusionsDesc;
    }

    public void setExclusionsDesc(String exclusionsDesc) {
        this.exclusionsDesc = exclusionsDesc;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFederalAState() {
        return federalAState;
    }

    public void setFederalAState(String federalAState) {
        this.federalAState = federalAState;
    }

    public String getFederalCity() {
        return federalCity;
    }

    public void setFederalCity(String federalCity) {
        this.federalCity = federalCity;
    }

    public String getFederalDateOfBirth() {
        return federalDateOfBirth;
    }

    public void setFederalDateOfBirth(String federalDateOfBirth) {
        this.federalDateOfBirth = federalDateOfBirth;
    }

    public String getFederalFirstName() {
        return federalFirstName;
    }

    public void setFederalFirstName(String federalFirstName) {
        this.federalFirstName = federalFirstName;
    }

    public String getFederalLastName() {
        return federalLastName;
    }

    public void setFederalLastName(String federalLastName) {
        this.federalLastName = federalLastName;
    }

    public String getFederalMiddleInitail() {
        return federalMiddleInitail;
    }

    public void setFederalMiddleInitail(String federalMiddleInitail) {
        this.federalMiddleInitail = federalMiddleInitail;
    }

    public Long getFederalPhone() {
        return federalPhone;
    }

    public void setFederalPhone(Long federalPhone) {
        this.federalPhone = federalPhone;
    }

    public String getFederalProviderSpeciality() {
        return federalProviderSpeciality;
    }

    public void setFederalProviderSpeciality(String federalProviderSpeciality) {
        this.federalProviderSpeciality = federalProviderSpeciality;
    }

    public String getFederalProviderType() {
        return federalProviderType;
    }

    public void setFederalProviderType(String federalProviderType) {
        this.federalProviderType = federalProviderType;
    }

    public String getFederalStreet() {
        return federalStreet;
    }

    public void setFederalStreet(String federalStreet) {
        this.federalStreet = federalStreet;
    }

    public String getFederalSuffix() {
        return federalSuffix;
    }

    public void setFederalSuffix(String federalSuffix) {
        this.federalSuffix = federalSuffix;
    }

    public String getFederalzZipcode() {
        return federalzZipcode;
    }

    public void setFederalzZipcode(String federalzZipcode) {
        this.federalzZipcode = federalzZipcode;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getMemberAState() {
        return memberAState;
    }

    public void setMemberAState(String memberAState) {
        this.memberAState = memberAState;
    }

    public String getMemberCity() {
        return memberCity;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public String getMemberDateOfBirth() {
        return memberDateOfBirth;
    }

    public void setMemberDateOfBirth(String memberDateOfBirth) {
        this.memberDateOfBirth = memberDateOfBirth;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String getMemberMiddleInitail() {
        return memberMiddleInitail;
    }

    public void setMemberMiddleInitail(String memberMiddleInitail) {
        this.memberMiddleInitail = memberMiddleInitail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberProviderSpeciality() {
        return memberProviderSpeciality;
    }

    public void setMemberProviderSpeciality(String memberProviderSpeciality) {
        this.memberProviderSpeciality = memberProviderSpeciality;
    }

    public String getMemberProviderType() {
        return memberProviderType;
    }

    public void setMemberProviderType(String memberProviderType) {
        this.memberProviderType = memberProviderType;
    }

    public String getMemberStreet() {
        return memberStreet;
    }

    public void setMemberStreet(String memberStreet) {
        this.memberStreet = memberStreet;
    }

    public String getMemberSuffix() {
        return memberSuffix;
    }

    public void setMemberSuffix(String memberSuffix) {
        this.memberSuffix = memberSuffix;
    }

    public String getMemberzZipcode() {
        return memberzZipcode;
    }

    public void setMemberzZipcode(String memberzZipcode) {
        this.memberzZipcode = memberzZipcode;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getProviderSpecialty() {
        return providerSpecialty;
    }

    public void setProviderSpecialty(String providerSpecialty) {
        this.providerSpecialty = providerSpecialty;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
}
