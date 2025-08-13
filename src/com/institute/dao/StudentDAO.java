package com.institute.dao;

import com.institute.models.Student;
import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudent(int studentId);
    List<Student> getAllStudents();
}
