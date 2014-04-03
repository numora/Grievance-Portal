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
				  Congratulations You have successfully created your Grievance. Please track your grievance using this tracking Id :${grievanceVB.grievanceId}
				  	</form:form>
			</spring:bind>
		</div>
	</div>
</div>
</div>