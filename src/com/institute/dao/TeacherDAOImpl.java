package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    private Connection connection;

    public TeacherDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        try {
            String query = "INSERT INTO teachers (first_name, last_name, qualification, hire_date, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setString(3, teacher.getQualification());
            ps.setDate(4, new java.sql.Date(teacher.getHireDate().getTime()));
            ps.setString(5, teacher.getPhone());
            ps.setString(6, teacher.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try {
            String query = "UPDATE teachers SET first_name=?, last_name=?, qualification=?, hire_date=?, phone=?, email=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setString(3, teacher.getQualification());
            ps.setDate(4, new java.sql.Date(teacher.getHireDate().getTime()));
            ps.setString(5, teacher.getPhone());
            ps.setString(6, teacher.getEmail());
            ps.setInt(7, teacher.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacher(int teacherId) {
        try {
            String query = "DELETE FROM teachers WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        Teacher teacher = null;
        try {
            String query = "SELECT * FROM teachers WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, teacherId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setQualification(rs.getString("qualification"));
                teacher.setHireDate(rs.getDate("hire_date"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            String query = "SELECT * FROM teachers";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setQualification(rs.getString("qualification"));
                teacher.setHireDate(rs.getDate("hire_date"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setEmail(rs.getString("email"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
