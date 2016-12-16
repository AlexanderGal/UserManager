<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
	<title>
		Spring MVC Form Handling Example
	</title>
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
	<link href="${bootstrapCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/users/add" var="urlAddUser"/>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
		</div>
		<div class="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
					<a href="${urlAddUser}">Add User</a>
				</li>
			</ul>
		</div>
	</div>
</nav>