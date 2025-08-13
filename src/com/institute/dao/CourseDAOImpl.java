package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private Connection connection;

    public CourseDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addCourse(Course course) {
        try {
            String query = "INSERT INTO courses (course_name, description, credits, department_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getCredits());
            ps.setInt(4, course.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            String query = "UPDATE courses SET course_name=?, description=?, credits=?, department_id=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getCredits());
            ps.setInt(4, course.getDepartmentId());
            ps.setInt(5, course.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        try {
            String query = "DELETE FROM courses WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourse(int courseId) {
        Course course = null;
        try {
            String query = "SELECT * FROM courses WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDescription(rs.getString("description"));
                course.setCredits(rs.getInt("credits"));
                course.setDepartmentId(rs.getInt("department_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            String query = "SELECT * FROM courses";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDescription(rs.getString("description"));
                course.setCredits(rs.getInt("credits"));
                course.setDepartmentId(rs.getInt("department_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
