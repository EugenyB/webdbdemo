<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="allagents.html">Hello Servlet</a>
<form method="post" action="salesagent.html">
    <label for="year">Year</label>
    <input id="year" type="number" name="year">
    <input type="submit" value="Find">
</form>
</body>
</html>