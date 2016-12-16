<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryUrl"/>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"></spring:url>
<div class="container">
	<hr>
	<footer>
		<p>&copy;Test Spring MVC</p>
	</footer>
</div>

<script src="${jqueryUrl}"></script>
<script src="${bootstrapJs}"></script>