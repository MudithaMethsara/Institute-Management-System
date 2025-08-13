package com.institute.services;

import com.institute.dao.AttendanceDAO;
import com.institute.dao.AttendanceDAOImpl;
import com.institute.models.Attendance;
import java.util.List;

public class AttendanceService {
    private AttendanceDAO attendanceDAO;

    public AttendanceService() {
        this.attendanceDAO = new AttendanceDAOImpl();
    }

    public void addAttendance(Attendance attendance) {
        // Add business logic here, e.g., validation
        attendanceDAO.addAttendance(attendance);
    }

    public void updateAttendance(Attendance attendance) {
        // Add business logic here
        attendanceDAO.updateAttendance(attendance);
    }

    public void deleteAttendance(int attendanceId) {
        // Add business logic here
        attendanceDAO.deleteAttendance(attendanceId);
    }

    public Attendance getAttendance(int attendanceId) {
        return attendanceDAO.getAttendance(attendanceId);
    }

    public List<Attendance> getAttendanceForStudent(int studentId) {
        return attendanceDAO.getAttendanceForStudent(studentId);
    }
}
