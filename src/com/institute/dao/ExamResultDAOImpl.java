package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.ExamResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamResultDAOImpl implements ExamResultDAO {

    private Connection connection;

    public ExamResultDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addExamResult(ExamResult examResult) {
        try {
            String query = "INSERT INTO exam_results (student_id, course_id, score, grade) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, examResult.getStudentId());
            ps.setInt(2, examResult.getCourseId());
            ps.setDouble(3, examResult.getScore());
            ps.setString(4, examResult.getGrade());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateExamResult(ExamResult examResult) {
        try {
            String query = "UPDATE exam_results SET student_id=?, course_id=?, score=?, grade=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, examResult.getStudentId());
            ps.setInt(2, examResult.getCourseId());
            ps.setDouble(3, examResult.getScore());
            ps.setString(4, examResult.getGrade());
            ps.setInt(5, examResult.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExamResult(int examResultId) {
        try {
            String query = "DELETE FROM exam_results WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, examResultId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ExamResult getExamResult(int examResultId) {
        ExamResult examResult = null;
        try {
            String query = "SELECT * FROM exam_results WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, examResultId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                examResult = new ExamResult();
                examResult.setId(rs.getInt("id"));
                examResult.setStudentId(rs.getInt("student_id"));
                examResult.setCourseId(rs.getInt("course_id"));
                examResult.setScore(rs.getDouble("score"));
                examResult.setGrade(rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examResult;
    }

    @Override
    public List<ExamResult> getExamResultsForStudent(int studentId) {
        List<ExamResult> examResults = new ArrayList<>();
        try {
            String query = "SELECT * FROM exam_results WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExamResult examResult = new ExamResult();
                examResult.setId(rs.getInt("id"));
                examResult.setStudentId(rs.getInt("student_id"));
                examResult.setCourseId(rs.getInt("course_id"));
                examResult.setScore(rs.getDouble("score"));
                examResult.setGrade(rs.getString("grade"));
                examResults.add(examResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examResults;
    }
}
