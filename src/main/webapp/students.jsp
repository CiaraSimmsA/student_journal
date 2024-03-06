<%@ page import="java.util.List" %>
<%@ page import="com.example.trynomer3.Student" %>
<%@ page import="com.example.trynomer3.StudentService" %>
<%@ page import="com.example.trynomer3.DAOimplementation" %>
<%
    StudentService studentService = new StudentService(new DAOimplementation());
    List<Student> students = studentService.findAll();
%>

<html>
<head>
    <title>Students</title>
</head>
<body>
<h1>Students</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>