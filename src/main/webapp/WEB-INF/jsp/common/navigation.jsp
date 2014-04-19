<%@ page language="java" import="com.grievance.web.healthcare.viewbean.ProfileVB" %>
<html>
<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<!-- navigation links -->


<div id="nav">
	<nav>
		<ul>
			<%
			
				if (null != request.getSession().getAttribute("profileVB")) {
					ProfileVB profileVB = (ProfileVB) request.getSession(true).getAttribute(
							"profileVB");
					pageContext.setAttribute("roleId", profileVB.getRoldId());
					int roleId = profileVB.getRoldId() ;
				}
			%>
			<c:choose>
				<c:when test="${(roleId == 1)}">
			        <li id="menu1" onclick='setCurrentPage(1);'><a
						href="#about">about</a></li>
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/getGrievance">Grievance</a></li>
					<li id="menu3" onclick='setCurrentPage(4);'><a
						href="${pageContext.request.contextPath}/grievance/trackGrievances">Track
							All Grievances</a></li>
					<li id="menu4" onclick='setCurrentPage(4);'><a href="#contact">contact
							us</a></li>
				</c:when>
				<c:when test="${(roleId == 2)}">
			        <li id="menu1" onclick='setCurrentPage(1);'><a
						href="#about">about</a></li>
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/getGrievance">Grievance</a></li>
					<li id="menu3" onclick='setCurrentPage(4);'><a
						href="${pageContext.request.contextPath}/grievance/trackGrievances">Track
							All Grievances</a></li>					
				</c:when>
				<c:when test="${(roleId == 3)}">
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/getGrievance">Grievance</a></li>
					<li id="menu3" onclick='setCurrentPage(4);'><a
						href="${pageContext.request.contextPath}/grievance/trackGrievances">Track
							All Grievances</a></li>
				</c:when>
				<c:otherwise>
					<li id="menu1" onclick='setCurrentPage(1);'><a href="#about">about</a></li>
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/signin">login</a></li>
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/createProfile">registration</a></li>

					<li id="menu4" onclick='setCurrentPage(4);'><a href="#contact">contact
							us</a></li>
				</c:otherwise>
			</c:choose>
		</ul>

	</nav>
</div>

</html>