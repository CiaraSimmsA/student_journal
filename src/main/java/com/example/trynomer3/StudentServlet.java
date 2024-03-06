package com.example.trynomer3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService(new DAOimplementation());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                List<Student> students = studentService.findAll();
                req.setAttribute("student", students);
                req.getRequestDispatcher("students.jsp").forward(req, resp);
                break;
            case "create":
                req.getRequestDispatcher("create.jsp").forward(req, resp);
                break;
            case "edit":
                Long id = Long.parseLong(req.getParameter("id"));
                Student studentToEdit = studentService.findById(id);
                req.setAttribute("student", studentToEdit);
                req.getRequestDispatcher("update.jsp").forward(req, resp);
                break;
            case "delete":
                Long idToDelete = Long.parseLong(req.getParameter("id"));
                studentService.deleteById(idToDelete);
                resp.sendRedirect("StudentServlet?action=list");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                if (name == null || email == null) {
                    // Handle the case where the name or email parameters are missing
                    req.setAttribute("errorMessage", "Name and email are required to create a student.");
                    req.getRequestDispatcher("create.jsp").forward(req, resp);
                    return;
                }
                Student student = new Student(email);
                studentService.save(student);
                resp.sendRedirect("StudentServlet?action=list");
                break;
// ...
            case "update":
                Long idToUpdate = Long.parseLong(req.getParameter("id"));
                String nameToUpdate = req.getParameter("name");
                String emailToUpdate = req.getParameter("email");
                if (nameToUpdate == null || emailToUpdate == null) {
                    // Handle the case where the name or email parameters are missing
                    req.setAttribute("errorMessage", "Name and email are required to update a student.");
                    Student studentToUpdateObj = studentService.findById(idToUpdate);
                    req.setAttribute("student", studentToUpdateObj);
                    req.getRequestDispatcher("update.jsp").forward(req, resp);
                    return;
                }
                Student studentToUpdateObj = studentService.findById(idToUpdate);
                if (studentToUpdateObj != null) {
                    studentToUpdateObj.setName(nameToUpdate);
                    studentToUpdateObj.setEmail(emailToUpdate);
                    studentService.save(studentToUpdateObj);
                    resp.sendRedirect("StudentServlet?action=list");
                } else {
                    // Handle the case where the student with the specified ID doesn't exist
                    req.setAttribute("errorMessage", "Student with ID " + idToUpdate + " not found.");
                    req.getRequestDispatcher("update.jsp").forward(req, resp);
                }
                break;
// ...

            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}