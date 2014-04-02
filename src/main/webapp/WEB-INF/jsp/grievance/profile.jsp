<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="container">
	<div id="content">
		<spring:bind path="profileVB.*">
			<form:form modelAttribute="profileVB" id="profileForm" method="POST">
				<form:label path="email" id="email">
					<fmt:message key="profile.userForm.emailAddress" />
				</form:label>
				<form:input id="email" name="email" path="email" maxlength="20" />
				<form:errors path="email" cssClass="error" />
				</br>
				<form:label path="password" id="password">
					<fmt:message key="profile.userForm.password" />
				</form:label>
				<form:password id="password" name="password" path="password"
					maxlength="20" />
				<form:errors path="password" cssClass="error" />
				</br>

				<form:label path="confirmPassword" id="confirmPassword">
					<fmt:message key="profile.userForm.confirmPassword" />
				</form:label>
				<form:password id="confirmPassword" name="confirmPassword"
					path="confirmPassword" maxlength="20" />
				<form:errors path="confirmPassword" cssClass="error" />
				</br>

				<form:label path="loginName" id="loginName">
					<fmt:message key="profile.userForm.loginName" />
				</form:label>
				<form:input id="loginName" name="loginName" path="loginName"
					maxlength="20" />
				<form:errors path="loginName" cssClass="error" />
				</br>

				<form:label path="address.addressLine1" id="address.addressLine1">
					<fmt:message key="profile.userForm.addressline1" />
				</form:label>
				<form:input id="address.addressLine1" name="addressline1"
					path="address.addressLine1" maxlength="20" />
				<form:errors path="address.addressLine1" cssClass="error" />
				</br>

				<form:label path="address.addressLine2" id="address.addressLine2">
					<fmt:message key="profile.userForm.addressline2" />
				</form:label>
				<form:input id="address.addressLine2" name="addressline2"
					path="address.addressLine2" maxlength="20" />
				<form:errors path="address.addressLine2" cssClass="error" />
				</br>

				<form:label path="address.city" id="address.city">
					<fmt:message key="profile.userForm.city" />
				</form:label>
				<form:input id="city" name="city" path="address.city" maxlength="20" />
				<form:errors path="address.city" cssClass="error" />
				</br>

				<form:label path="address.state" id="address.state">
					<c:out value="${icon}" escapeXml="false"></c:out>
					<fmt:message key="profile.userForm.state" />
				</form:label>
				<form:select path="address.state" class="stateDropdown">
					<form:option label="Select" value="-1"></form:option>
					<form:options items="${profileVB.states}"></form:options>
					</br>
				</form:select>
				<br>
				<form:label path="address.postalCode" id="address.postalCode">
					<c:out value="${icon}" escapeXml="false"></c:out>
					<fmt:message key="profile.userForm.postalCode" />
				</form:label>
				<form:input id="address.postalCode" name="address.postalCode"
					path="address.postalCode" maxlength="20" />
				<form:errors path="address.postalCode" cssClass="error" />
				</br>

				<button type="submit" id="submit" name="createProfile">
					<span>Create Profile</span>
				</button>

			</form:form>
		</spring:bind>
	</div>
</div>

