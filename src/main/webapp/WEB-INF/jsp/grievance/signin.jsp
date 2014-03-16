<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="container">
	<div id="content">
		<div>
			<spring:bind path="signInVB.*">
				<form:form modelAttribute="signInVB" id="signInForm" method="POST">
					<form:label path="email" id="email">
						<fmt:message key="signin.userForm.emailAddress"/>
					</form:label>
				    <form:input id="email" name="email" path="email" maxlength="20" /> 
				    <form:errors path="email" cssClass="error" /></br>
				    <form:label path="password" id="password">
				    	<fmt:message key="signin.userForm.password"/>
					</form:label>
				    <form:password id="password" name="password" path="password" maxlength="20" /> 
				    <form:errors path="password" cssClass="error" /></br>
				    <button type="submit" id="submit" name="processSignIn"><span>SignIn</span></button>
				    <a href="#" id="forgotPassword">forgot password?</a>
				</form:form>
			</spring:bind>
		</div>
	</div>
</div>	