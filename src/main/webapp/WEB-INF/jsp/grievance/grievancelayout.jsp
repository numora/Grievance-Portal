<!DOCTYPE html>
<jsp:directive.include file="/WEB-INF/jsp/common/taglibs.jsp" />
<html>
	<head>
		<!-- Basic -->
		<meta charset="utf-8">
		<!-- Page title -->
		<tiles:getAsString name="title" /></title>
		<!-- Meta tags -->
		<meta name="keywords" content="CIS660, HTML, CSS, JavaScript" />
		<meta name="description" content="HTML, CSS, JavaScript Course Excercises and assignments">
		<meta name="author" content="Srinivas Gangapurkar">
		<!-- Favorite icon -->
		<link rel="shortcut icon" href="images/favicon.ico">
		<!-- Web fonts -->
		<link href='http://fonts.googleapis.com/css?family=Chela+One|Crushed|Open+Sans:400,600' rel='stylesheet' type='text/css'>
		<!-- CSS styles -->
		<link rel="stylesheet" type="text/css" href="../css/app_main.css">
		<style type = "text/css">
		</style>
		<!-- JavaScript -->
		<script src = "../js/nav.js"></script>
	</head>
	<body border="2">
		<!-- BEGIN: Sticky Header -->
		<div id="header_container">
			<div id="header_section">
		    	<tiles:insertAttribute name="header" />
			</div>

		</div>
		 <div id="body">
			    <tiles:insertAttribute name="body" />
		 </div>
		 <div id="footer_container">
			    <tiles:insertAttribute name="footer" />
		 </div>
	</body>
</html>