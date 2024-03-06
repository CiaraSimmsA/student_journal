<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form action="StudentServlet" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${student.name}" required><br>
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="${student.email}" required><br>
    <button type="submit">Update</button>
</form>
</body>
</html>