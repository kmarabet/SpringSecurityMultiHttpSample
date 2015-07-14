<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Session Attributes</title>
	<link rel="stylesheet" href="/resources/landing.css">
	<style type="text/css">
		body {
			padding: 1em;
		}
	</style>
</head>
<body>

<%--<c:url value="/j_spring_security_logout" var="logoutUrl" />--%>
<c:url value="/logout" var="logoutUrl" />

<!-- csrt support -->
<form action="${logoutUrl}" method="post" id="logoutForm">
	<%--<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}" />--%>
</form>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<div class="container">

			<h2>
				Welcome : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
			</h2>

</div>

</body>
</html>
