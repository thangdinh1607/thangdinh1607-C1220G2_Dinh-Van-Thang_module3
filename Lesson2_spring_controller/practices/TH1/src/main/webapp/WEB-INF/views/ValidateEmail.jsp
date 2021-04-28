<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/28/2021
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate Email</title>
</head>
<body>
<h1>Validate Email</h1>
<p>${email}</p>
<form action="/validate" method="post">
    <input type="text" name="email">
    <input type="submit" value="check">
</form>

</body>
</html>
