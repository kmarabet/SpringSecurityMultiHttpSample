<%@page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/j_spring_security_check" var="loginUrl" />
<%--<c:url value="/login" var="loginUrl" />--%>

<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" href="./resources/login.css" />

</head>
<body onload='document.loginForm.username.focus();'>

<h1>SpringSessionWebRestSample WebApp</h1>

<div id="login-box">

  <h2>Login with user/password</h2>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form name='loginForm' action="${loginUrl}" method='POST' accept-charset="UTF-8">

    <table>
      <tr>
        <td>Username:</td>
        <td><input type='text' name='username' value=''></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <td colspan='2'>
          <input name="submit" type="submit" value="submit" />
        </td>
      </tr>
    </table>

    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
  </form>
</div>

</body>
</html>