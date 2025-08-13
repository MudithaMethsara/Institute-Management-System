package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    private Connection connection;

    public AttendanceDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addAttendance(Attendance attendance) {
        try {
            String query = "INSERT INTO attendance (student_id, attendance_date, is_present) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendance.getStudentId());
            ps.setDate(2, new java.sql.Date(attendance.getAttendanceDate().getTime()));
            ps.setBoolean(3, attendance.isPresent());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        try {
            String query = "UPDATE attendance SET student_id=?, attendance_date=?, is_present=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendance.getStudentId());
            ps.setDate(2, new java.sql.Date(attendance.getAttendanceDate().getTime()));
            ps.setBoolean(3, attendance.isPresent());
            ps.setInt(4, attendance.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAttendance(int attendanceId) {
        try {
            String query = "DELETE FROM attendance WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendanceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Attendance getAttendance(int attendanceId) {
        Attendance attendance = null;
        try {
            String query = "SELECT * FROM attendance WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendanceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                attendance = new Attendance();
                attendance.setId(rs.getInt("id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setPresent(rs.getBoolean("is_present"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }

    @Override
    public List<Attendance> getAttendanceForStudent(int studentId) {
        List<Attendance> attendances = new ArrayList<>();
        try {
            String query = "SELECT * FROM attendance WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setId(rs.getInt("id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setPresent(rs.getBoolean("is_present"));
                attendances.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
}
