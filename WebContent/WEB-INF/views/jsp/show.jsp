<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype>
<html>
<jsp:include page="./header.jsp"/>

	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-{$css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
								arial-label="Close">
					<span aria-hidden="true">x</span>				
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		
		<h1>User Detail</h1>
		<br/>
		
		<div class="row">
			<label class="col-sm-2">ID</label>
			<div class="col-sm-10">${user.id}</div>
		</div>
		<div class="row">
			<label class="col-sm-2">Name</label>
			<div class="col-sm-10">${user.name}</div>
		</div>
		<div class="row">
			<label class="col-sm-2">Address</label>
			<div class="col-sm-10">${user.address}</div>
		</div>		
		<div class="row">
			<label class="col-sm-2">Newsletter</label>
			<div class="col-sm-10">${user.newsletter}</div>
		</div>
		<%-- <div class="row">
			<label class="col-sm-2">Web Frameworks</label>
			<div class="col-sm-10">${user.frameworks}</div>
		</div> --%>
		<div class="row">
			<label class="col-sm-2">Country</label>
			<div class="col-sm-10">${user.country}</div>
		</div>
		<%--  <div class="row">
			<label class="col-sm-2">Skill</label>
			<div class="col-sm-10">${user.skill}</div>
		</div> --%>
	</div>
	
	<jsp:include page="./footer.jsp"/>

</html>