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
	<c:choose>
		<c:when test="${userForm['new']}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	
	<spring:url value="/users" var="userActionUrl"/>
	
	<form:form class="form-horizontal" method="post"
					modelAttribute="userForm" action="${userActionUrl}">
			<form:hidden path="id"/>
			
			<spring:bind path="name">
				<div class="form group ${status.error ? 'has-error' : ''}" >
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control" id="name" placeholder="Name"/>					
						<form:errors path="name" class="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
	</form:form>
</div>
</html>