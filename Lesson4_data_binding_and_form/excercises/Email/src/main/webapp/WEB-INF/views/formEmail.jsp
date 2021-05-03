<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 4/29/2021
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="setting" action="/info" method="post">
    <table>
        <tr>
            <th>
            <td>languages</td>
            <td><form:select path="languages" items="${Languages}"/></td>
            </th>
        </tr>
        <tr>
            <th>
            <td>sizePage</td>
            <td><form:select path="sizePage" items="${sizePage}"/></td>
            </th>

        </tr>
        <tr>
            <th>
            <td>spamFilter</td>
            <td><form:select path="spamFilter"/></td>
            </th>
        </tr>
        <tr>
            <th>
            <td>signNature</td>
            <td><form:input path="signNature"/></td>
            </th>

        </tr>
<tr>
    <th>
    </th>
    <th>
    <td> <input type="submit" value="Update"> </td>
    </th>
    <th>
    <td> <button><a href="/info">Cancel</a></button> </td>
    </th>
</tr>




    </table>

</form:form>
</body>
</html>
