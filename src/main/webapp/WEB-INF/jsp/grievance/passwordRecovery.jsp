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
				<form:form modelAttribute="profileVB" id="passwordRecoveryForm"
					method="POST">
					<form:label path="password" id="password">
						Password
					</form:label>
					<form:password id="password" name="password" path="password" maxlength="20" />
					<br>
					<br>
					<form:label path="confirmPassword" id="confirmPassword">
						Confirm Password
					</form:label>
					<form:password id="confirmPassword" name="confirmPassword" path="confirmPassword" maxlength="20" />
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
