<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="container">
	<div id="content">
		<spring:bind path="grievanceVB.*">
			<form:form modelAttribute="grievanceVB" id="grievanceForm"
				method="POST">
				<h3>Provider Info</h3>
				<form:select path="memberVB.providerId" class="providerDropdown">
					<form:option label="Anthem" value="0"></form:option>
					<form:option label="Kaiser" value="1"></form:option>
					<form:option label="Anthem Kaiser" value="2"></form:option>
					<br>
				</form:select>
				<h3>Member Info</h3>
				<br>
				<form:label path="memberVB.firstName" id="memberVB.firstName">
					Member FirstName
				</form:label>
				<form:input id="memberVB.firstName" name="memberVB.firstName"
					path="memberVB.firstName" maxlength="80" />
				<br>
				<form:label path="memberVB.lastName" id="memberVB.lastName">
					Member Last Name
				</form:label>
				<form:input id="memberVB.lastName" name="memberVB.lastName"
					path="memberVB.lastName" maxlength="80" />
				<br>
				<form:label path="memberVB.middleInitial"
					id="memberVB.middleInitial">
					Member Middle Initial
				</form:label>
				<form:input id="memberVB.middleInitial"
					name="memberVB.middleInitial" path="memberVB.middleInitial"
					maxlength="80" />
				<br>
				<form:label path="memberVB.suffix" id="memberVB.suffix">
					Member Suffix
				</form:label>
				<form:input id="memberVB.suffix" name="memberVB.suffix"
					path="memberVB.suffix" maxlength="80" />
				<br>
				<form:label path="memberVB.phone" id="memberVB.phone">
					Member Phone
				</form:label>
				<form:input id="memberVB.phone" name="memberVB.phone"
					path="memberVB.phone" maxlength="80" />
				<br>
				<h3>Member Address Info</h3>
				<form:label path="memberVB.address.addressLine1"
					id="memberVB.address.addressLine1">
					Address Line 1
				</form:label>
				<form:input id="memberVB.address.addressLine1"
					name="memberVB.address.addressLine1"
					path="memberVB.address.addressLine1" maxlength="80" />
				<br>
				<form:label path="memberVB.address.addressLine2"
					id="memberVB.address.addressLine2">
					Address Line 2
				</form:label>
				<form:input id="memberVB.address.addressLine2"
					name="memberVB.address.addressLine2"
					path="memberVB.address.addressLine2" maxlength="80" />
				<br>
				<form:label path="memberVB.address.city" id="memberVB.address.city">
					City
				</form:label>
				<form:input id="memberVB.address.city" name="memberVB.address.city"
					path="memberVB.address.city" maxlength="80" />
				<br>
				<form:label path="memberVB.address.postalCode"
					id="memberVB.address.postalCode">
					ZipCode
				</form:label>
				<form:input id="memberVB.address.postalCode"
					name="memberVB.address.postalCode"
					path="memberVB.address.postalCode" maxlength="80" />
				<br>

				<form:label path="memberVB.address.state"
					id="memberVB.address.state">
					State
				</form:label>
				<form:input id="memberVB.address.state"
					name="memberVB.address.state" path="memberVB.address.state"
					maxlength="80" />
				<br>


				<h3>Fed Member Info</h3>
				<h3>Provider Info</h3>
				<form:select path="fedMemberVB.providerId" class="providerDropdown">
					<form:option label="Anthem" value="0"></form:option>
					<form:option label="Kaiser" value="1"></form:option>
					<form:option label="Anthem Kaiser" value="2"></form:option>
					<br>
				</form:select>
				<br>
				<form:label path="fedMemberVB.firstName" id="fedMemberVB.firstName">
					 Member FirstName
				</form:label>
				<form:input id="fedMemberVB.firstName" name="fedMemberVB.firstName"
					path="fedMemberVB.firstName" maxlength="80" />
				<br>
				<form:label path="fedMemberVB.lastName" id="fedMemberVB.lastName">
					 Member Last Name
				</form:label>
				<form:input id="fedMemberVB.lastName" name="fedMemberVB.lastName"
					path="fedMemberVB.lastName" maxlength="80" />
				<br>
				<form:label path="fedMemberVB.middleInitial"
					id="fedMemberVB.middleInitial">
					 Member Middle Initial
				</form:label>
				<form:input id="fedMemberVB.middleInitial"
					name="fedMemberVB.middleInitial" path="fedMemberVB.middleInitial"
					maxlength="80" />
				<br>
				<form:label path="fedMemberVB.suffix" id="fedMemberVB.suffix">
					Member Suffix
				</form:label>
				<form:input id="fedMemberVB.suffix" name="fedMemberVB.suffix"
					path="fedMemberVB.suffix" maxlength="80" />
				<br>
				<form:label path="fedMemberVB.phone" id="fedMemberVB.phone">
					Member Phone
				</form:label>
				<form:input id="fedMemberVB.phone" name="fedMemberVB.phone"
					path="fedMemberVB.phone" maxlength="80" />
				<br>
				<h3>Fed Member Address Info</h3>
				<form:label path="fedMemberVB.address.addressLine1"
					id="fedMemberVB.address.addressLine1">
					Address Line 1
				</form:label>
				<form:input id="fedMemberVB.address.addressLine1"
					name="fedMemberVB.address.addressLine1"
					path="fedMemberVB.address.addressLine1" maxlength="80" />
				<br>
				<form:label path="fedMemberVB.address.addressLine2"
					id="fedMemberVB.address.addressLine2">
					Address Line 2
				</form:label>
				<form:input id="fedMemberVB.address.addressLine2"
					name="fedMemberVB.address.addressLine2"
					path="fedMemberVB.address.addressLine2" maxlength="80" />
				<br>
				<form:label path="fedMemberVB.address.city"
					id="fedMemberVB.address.city">
					City
				</form:label>
				<form:input id="fedMemberVB.address.city"
					name="fedMemberVB.address.city" path="fedMemberVB.address.city"
					maxlength="80" />
				<br>
				<form:label path="fedMemberVB.address.postalCode"
					id="fedMemberVB.address.postalCode">
					ZipCode
				</form:label>
				<form:input id="fedMemberVB.address.postalCode"
					name="fedMemberVB.address.postalCode"
					path="fedMemberVB.address.postalCode" maxlength="80" />
				<br>

				<form:label path="fedMemberVB.address.state"
					id="fedMemberVB.address.state">
					State
				</form:label>
				<form:input id="fedMemberVB.address.state"
					name="fedMemberVB.address.state" path="fedMemberVB.address.state"
					maxlength="80" />
				<br>

				<h3>Grievance Info</h3>

				<form:label path="grievanceType" id="grievanceType">
					Grievance Type
				</form:label>
				<form:input id="grievanceType" name="grievanceType"
					path="grievanceType" maxlength="80" />
				<form:errors path="grievanceType" cssClass="error" />
				<br>
				<form:label path="SSN" id="SSN">
					SSN
				</form:label>
				<form:input id="SSN" name="SSN" path="SSN" maxlength="80" />
				<form:errors path="SSN" cssClass="error" />
				<br>
				<form:label path="contactEmail" id="contactEmail">
					Contact Email
				</form:label>
				<form:input id="contactEmail" name="contactEmail"
					path="contactEmail" maxlength="80" />
				<form:errors path="contactEmail" cssClass="error" />
				<br>
				<form:label path="contactPhone" id="contactPhone">
					Contact Phone
				</form:label>
				<form:input id="contactPhone" name="contactPhone"
					path="contactPhone" maxlength="80" />
				<form:errors path="contactPhone" cssClass="error" />
				<br>
				<form:label path="licenseType" id="licenseType">
					License Type
				</form:label>
				<form:input id="licenseType" name="licenseType" path="licenseType"
					maxlength="80" />
				<form:errors path="licenseType" cssClass="error" />
				<br>
				<form:label path="licenseNumber" id="licenseNumber">
					License Number
				</form:label>
				<form:input id="licenseNumber" name="licenseNumber"
					path="licenseNumber" maxlength="80" />
				<form:errors path="licenseNumber" cssClass="error" />
				<br>
				<form:label path="licenseExpDate" id="licenseExpDate">
					License Expiry Date
				</form:label>
				<form:input id="licenseExpDate" name="licenseExpDate"
					path="licenseExpDate" maxlength="80" />
				<form:errors path="licenseExpDate" cssClass="error" />
				<br>
				<form:label path="npi" id="npi">
					NPI
				</form:label>
				<form:input id="npi" name="npi" path="npi" maxlength="80" />
				<form:errors path="npi" cssClass="error" />
				<br>
				<form:label path="taxId" id="taxId">
					Tax Id 
				</form:label>
				<form:input id="taxId" name="taxId" path="taxId" maxlength="80" />
				<form:errors path="taxId" cssClass="error" />
				<br>
				<form:label path="exclusionCode" id="exclusionCode">
					Exclusion Code
				</form:label>
				<form:input id="exclusionCode" name="exclusionCode"
					path="exclusionCode" maxlength="80" />
				<form:errors path="exclusionCode" cssClass="error" />
				<br>
				<form:label path="exclusionDesc" id="exclusionDesc">
					Exclusion Desc
				</form:label>
				<form:input id="exclusionDesc" name="exclusionDesc"
					path="exclusionDesc" maxlength="80" />
				<br>
				<br>
				<form:label path="exclusionDate" id="exclusionDate">
					Exclusion Date
				</form:label>
				<form:input id="exclusionDate" name="exclusionDate"
					path="exclusionDate" maxlength="80" />
				<br>
				<br>
				<form:label path="taxonomy" id="taxonomy">
					Taxonomy
				</form:label>
				<form:input id="taxonomy" name="taxonomy" path="taxonomy"
					maxlength="80" />
				<br>
				<button type="submit" id="submit" name="createGrievance">
					<span>Create Grievance</span>
				</button>
			</form:form>
		</spring:bind>
	</div>
</div>

