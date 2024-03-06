<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Students</title>
</head>
<body>
<h1>Students</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>
                <a href="update.jsp?id=${student.id}">Update</a>
                <form action="StudentServlet" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="${student.id}">
                    <button type="submit" name="action" value="delete">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="create.jsp">Create New Student</a>
</body>
</html>