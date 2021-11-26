<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 26.11.2021
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
    <jsp:useBean id="empbean" scope="request" type="com.te.webdbdemo.beans.EmployeeBean"/>
    <h1>${empbean.size}</h1>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>last name</th>
            <th>first name</th>
            <th>title</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${empbean.employees}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.lastName}</td>
                    <td>${e.firstName}</td>
                    <td>${e.title}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
