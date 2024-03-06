<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h1>Create Student</h1>
<form action="StudentServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br>
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br>
    <button type="submit">Create</button>
</form>
</body>
</html>