<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/28/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/action">
    <input type="number" name="number1">
    <input type="number" name="number2">
    <p>
        <input type="submit" value="Addition" name="action">
        <input type="submit" value="Subtraction" name="action" >
        <input type="submit" value="Multiplication"name="action">
        <input type="submit" value="Division" name="action">
    </p>
</form>
<p>Result : ${result}</p>


</body>
</html>
