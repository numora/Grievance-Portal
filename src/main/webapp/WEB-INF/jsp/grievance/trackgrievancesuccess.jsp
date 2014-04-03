<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="container">
	<div id="content">
		<div>
			<spring:bind path="grievanceVB.*">
				<form:form modelAttribute="grievanceVB" id="grievanceForm"
					method="POST">
				  Congratulations You have successfully tracked your Grievance. Please find your grievance details below
				  <h3>Grievance Info</h3>
					<form:label path="grievanceType" id="grievanceType">
							Grievance Type
							</form:label>
							${grievanceVB.grievanceType}
							<br>
					<form:label path="SSN" id="SSN">
							SSN
							</form:label>
							${grievanceVB.SSN}
							<br>
					<form:label path="contactEmail" id="contactEmail">
							Contact Email
							</form:label>
							${grievanceVB.contactEmail}
							<br>
					<form:label path="contactPhone" id="contactPhone">
							Contact Phone
							</form:label>
							${grievanceVB.contactPhone}
							<br>
					<form:label path="licenseType" id="licenseType">
							License Type
							</form:label>
							${grievanceVB.licenseType}
							<br>
					<form:label path="licenseNumber" id="licenseNumber">
							License Number
							</form:label>
							${grievanceVB.licenseNumber}
							<br>
					<form:label path="licenseExpDate" id="licenseExpDate">
							License Expiry Date
							</form:label>
							${grievanceVB.licenseExpDate}
							<br>
					<form:label path="npi" id="npi">
							NPI
							</form:label>
							${grievanceVB.npi}
							<br>
					<form:label path="taxId" id="taxId">
							Tax Id 
							</form:label>
							${grievanceVB.taxId}
							<br>
					<form:label path="exclusionCode" id="exclusionCode">
							Exclusion Code
							</form:label>
							${grievanceVB.exclusionCode}
							<br>
					<form:label path="exclusionDesc" id="exclusionDesc">
							Exclusion Desc
							</form:label>
							${grievanceVB.exclusionDesc}
							<br>
					<form:label path="exclusionDate" id="exclusionDate">
							Exclusion Date
							</form:label>
							${grievanceVB.exclusionDate}
							<br>
					<form:label path="taxonomy" id="taxonomy">
							Taxonomy
							</form:label>
							${grievanceVB.taxonomy}
							<br>
				</form:form>
			</spring:bind>
		</div>
	</div>
</div>
