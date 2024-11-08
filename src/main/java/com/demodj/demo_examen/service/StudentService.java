package com.demodj.demo_examen.service;

import com.demodj.demo_examen.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    void updateStudent(Student student);
}
