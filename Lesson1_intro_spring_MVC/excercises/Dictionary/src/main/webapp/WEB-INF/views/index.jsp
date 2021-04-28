<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/27/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Dictionary</h1>
  <form action="/dictionary" method="post">
    <input type="text" name="search">
    <input type="submit" value="search">
    <p>${result}</p>
  </form>
  </body>
</html>
