<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/29/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>login</h1>
<form:form modelAttribute="user" action="/login" method="post">
    <p>Account <form:input path="account"/></p>
   <p> Password <form:input type="number"  path="passwords" /></p>
    <input type="submit" value="login">
</form:form>
</body>
</html>
