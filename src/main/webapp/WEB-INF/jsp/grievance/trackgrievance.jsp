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
				<form:form modelAttribute="grievanceVB" id="trackGrievanceForm"
					method="POST">
					<form:label path="grievanceId" id="grievanceId">Tracking Id </form:label>
				     <form:input id="grievanceId" name="grievanceId" path="grievanceId" maxlength="20" /><br><br>
					<form:label path="contactEmail" id="contactEmail">Email Address</form:label>
				    <form:input id="contactEmail" name="contactEmail"path="contactEmail" maxlength="20" /><br><br>
					<form:label path="SSN" id="SSN">SSN</form:label>
					<form:input id="SSN" name="SSN" path="SSN" maxlength="20" /><br><br>
					<button type="submit" id="submit" name="trackGrievance"> Track Your Grievance</button>
				</form:form>
			</spring:bind>
		</div>
	</div>
</div>
