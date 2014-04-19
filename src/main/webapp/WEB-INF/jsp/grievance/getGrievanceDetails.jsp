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
				  Please find your grievance details below
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

				</form:form>
			</spring:bind>

		</div>
	</div>
</div>
</div>