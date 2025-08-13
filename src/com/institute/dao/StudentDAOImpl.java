package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Connection connection;

    public StudentDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO students (first_name, last_name, dob, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            String query = "UPDATE students SET first_name=?, last_name=?, dob=?, address=?, phone=?, email=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getEmail());
            ps.setInt(7, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try {
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudent(int studentId) {
        Student student = null;
        try {
            String query = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setDateOfBirth(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setDateOfBirth(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
