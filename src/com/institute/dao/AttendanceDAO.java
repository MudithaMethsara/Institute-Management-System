package com.institute.dao;

import com.institute.models.Attendance;
import java.util.List;

public interface AttendanceDAO {
    void addAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(int attendanceId);
    Attendance getAttendance(int attendanceId);
    List<Attendance> getAttendanceForStudent(int studentId);
}
