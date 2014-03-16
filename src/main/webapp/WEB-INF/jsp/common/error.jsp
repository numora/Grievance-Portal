<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />

<c:if test="${status.errors.errorCount > 0}">
	<div id="generalErrorMsg" class="generalError">
	<!-- Global Error Message -->
	<c:if test="${status.errors.globalErrorCount > 0}">
			<sns:message code="${status.errors.globalError.codes[0]}" nestedMessage="true" />
	</c:if>
	<!-- Field Error Messages -->
	<c:forEach var="error" items="${status.errors.allErrors}">
		<c:if test="${error.class.name == 'org.springframework.validation.FieldError'}">
			<c:if test="${status.errors.globalErrorCount == 0}">
				<sns:message code="${error.codes[0]}" nestedMessage="true" /><BR>
			</c:if>
		</c:if>
	</c:forEach>
	</div>
</c:if>
