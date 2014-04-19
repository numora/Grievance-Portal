<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <script>
	function fireAjax() {
		var xmlhttp;
		alert("in ajax call");
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("SSN").innerHTML = xmlhttp.responseText;
			}
		}
		alert("test");
		var SSN = document.getElementById("SSN").value;
		alert(SSN);
		var url = "http://localhost:8080/grievance/grievance/createGrievance";
		url += "?SSN=" + SSN;
		alert(url);
		xmlHttp.open("POST", url, true);
		xmlhttp.send(null);
	}
</script> -->

<div id="container">
	<div id="content">
		<spring:bind path="grievanceVB.*">
			<form:form modelAttribute="grievanceVB" id="grievanceForm"
				method="POST">
				<form:label path="SSN" id="SSN">
					SSN
				</form:label>
				<form:input id="SSN" name="SSN" path="SSN" maxlength="80" />
				<form:errors path="SSN" cssClass="error" />
				<br>
				<form:label path="grievanceId" id="grievanceId">
					GrievanceId
				</form:label>
				<form:input id="grievanceId" name="grievanceId" path="grievanceId"
					maxlength="80" />
				<form:errors path="grievanceId" cssClass="error" />
				<br>
				<form:label path="memberVB.memberId" id="memberVB.memberId">
					MemberId
				</form:label>
				<form:input id="memberVB.memberId" name="memberVB.memberId"
					path="memberVB.memberId" maxlength="80" />
				<form:errors path="memberVB.memberId" cssClass="error" />
				<br>
				<button type="submit" id="submit" name="getGrievance">
					<span>Lookup Grievance</span>
				</button>
			</form:form>
		</spring:bind>
	</div>
</div>

