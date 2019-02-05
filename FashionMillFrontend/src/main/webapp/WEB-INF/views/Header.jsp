<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${pageinfo}FashionMill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>

<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Fashion Mill</a>
			</div>
			<c:if test="${!sessionScope.loggedIn}">
			<ul class="nav navbar-nav">
				<li><a href="home">HOME</a></li>
				<li><a href="<c:url value="/login"/>">LOGIN</a></li>
				<li><a href="<c:url value="/register"/>">REGISTER</a></li>
				<li><a href="<c:url value="/contactus"/>">Contact US</a></li>
				<li><a href="<c:url value="/aboutus"/>">About US</a></li>
			</ul>
			</c:if>
			<c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
						<ul class="nav navbar-nav" >
							<li><a href="<c:url value="/product"/>">Manage Product</a></li>
							<li><a href="<c:url value="/category"/>">Manage Category</a></li>
							<li><a href="<c:url value="/productDisplay"/>">Product Catalog</a></li>
						</ul>
					</c:if>
					<c:if test="${sessionScope.role=='ROLE_USER'}">
						<ul class="nav navbar-nav">
							 <li><a href="<c:url value="/userhome"/>">Home</a></li>
							 <li><a href="<c:url value="/productDisplay"/>">Product Catalog</a></li>
							 <li> <a href="<c:url value='/aboutus'/>"> ABOUT US </a></li>
                             <li> <a href="<c:url value='/contactus'/>"> CONTACT US </a></li>
                             <li> <a href="<c:url value='/cart'/>"> CART </a></li>
						</ul>
					</c:if>
			</c:if>
		</div>
		<c:if test="${sessionScope.loggedIn}">
		<div class="nav navbar-nav navbar-right">
			<font color="white" face="calibri" size="2">Welcome : ${sessionScope.username}</font>
			<a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a>
		</div>
		</c:if>
	</nav>
</div>		
</body>
</html>