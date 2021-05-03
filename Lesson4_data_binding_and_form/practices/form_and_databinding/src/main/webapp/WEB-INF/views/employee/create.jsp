<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/29/2021
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<h1>Create Employee</h1>
<form:form modelAttribute="employee" action="/addEmployee" method="post">
    <p>Name <form:input path="id"/></p>
    <p>ID <form:input path="name"/></p>
    <p>Contract Number <form:input path="contractNumber"/></p>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
