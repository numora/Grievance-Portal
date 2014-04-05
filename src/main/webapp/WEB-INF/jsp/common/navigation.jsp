<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<!-- navigation links -->

<div id="nav">
	<nav>
		<ul>
			<%
				if (null != request.getSession().getAttribute("signedIn")) {
					int signedIn = (Integer) request.getSession(true).getAttribute(
							"signedIn");
					pageContext.setAttribute("signedIn", signedIn);
				}
			%>
			<c:choose>
				<c:when test="${(signedIn eq '1')}">
			        Welcome User 
			        <li id="menu1" onclick='setCurrentPage(1);'><a
						href="#about">about</a></li>
					<li id="menu3" onclick='setCurrentPage(3);'><a
						href="${pageContext.request.contextPath}/grievance/createGrievance">Grievance</a></li>
					<li id="menu3" onclick='setCurrentPage(4);'><a
						href="${pageContext.request.contextPath}/grievance/trackGrievance">Track
							Grievance</a></li>
					<li id="menu4" onclick='setCurrentPage(4);'><a href="#contact">contact
							us</a></li>
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

