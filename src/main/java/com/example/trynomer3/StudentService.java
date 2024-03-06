package com.example.trynomer3;
import java.util.List;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public Student findStudentById(Long id) {
        return studentDao.findById(id);
    }

    public void saveOrUpdateStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudentById(Long id) {
        studentDao.deleteById(id);
    }

    public List<Student> findAll() {
        return null;
    }

    public void save(Student student) {
    }

    public Student findById(Long id) {
        return null;
    }

    public void deleteById(Long idToDelete) {
    }
}