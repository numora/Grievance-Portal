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
					method="GET">
					
					Please find the list of all grievances. Please click on each link to track respective grievance.<br>
					<br>
					<c:forEach var="grievances" items='${grievanceVB.grievances}'
						varStatus="status">
						<form:label path="grievanceId" id="grievanceId">
							<a
								href="/Grievance/grievance/getGrievanceDetails?id=${grievances.grievanceId}">
								${grievances.grievanceId}</a>
						</form:label>
						<br>
					</c:forEach>

				</form:form>
			</spring:bind>

		</div>
	</div>
</div>
