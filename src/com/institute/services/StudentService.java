package com.institute.services;

import com.institute.dao.StudentDAO;
import com.institute.dao.StudentDAOImpl;
import com.institute.models.Student;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
    }

    public void addStudent(Student student) {
        // Add business logic here, e.g., validation
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
        // Add business logic here
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        // Add business logic here
        studentDAO.deleteStudent(studentId);
    }

    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
