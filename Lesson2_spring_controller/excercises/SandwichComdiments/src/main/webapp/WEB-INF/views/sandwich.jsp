<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/28/2021
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1> Sandwich Condiments</h1>
<form action="/condiment" method="post">
    <p><input type="checkbox" value="lettuce" name="condiment1"> Lettuce
        <input type="checkbox" value="tomato" name="condiment1"> Tomato
        <input type="checkbox" value="mustard" name="condiment1"> Mustard
        <input type="checkbox" value="sprouts" name="condiment1"> Sprouts
    </p>
    <input type="submit" value="save">
</form>
</body>
</html>
