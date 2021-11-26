<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 26.11.2021
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    <jsp:useBean id="employee" type="com.te.webdbdemo.data.Employee" scope="request"/>
    <h1>${employee.title}</h1>
    <h2>${employee.firstName}</h2>
    <h2>${employee.lastName}</h2>
    <h2>${employee.info}</h2>
</body>
</html>
