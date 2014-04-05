<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="container">
	<div id="content">
		<div>
			<spring:bind path="profileVB.*">
				<form:form modelAttribute="profileVB" id="forgotPasswordForm"
					method="POST">
					<form:label path="email" id="email">
						Email
					</form:label>
					<form:input id="email" name="email" path="email" maxlength="20" />
					<br>
					<br>
					<button type="submit" id="submit" name="processSignIn">
						<span>Submit</span>
					</button>
				</form:form>
			</spring:bind>
		</div>
	</div>
</div>
