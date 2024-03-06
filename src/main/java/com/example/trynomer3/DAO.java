package com.example.trynomer3;
import java.util.List;

interface StudentDao {

    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void deleteById(Long id);
}