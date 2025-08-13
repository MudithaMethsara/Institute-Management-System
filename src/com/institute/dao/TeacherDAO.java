package com.institute.dao;

import com.institute.models.Teacher;
import java.util.List;

public interface TeacherDAO {
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int teacherId);
    Teacher getTeacher(int teacherId);
    List<Teacher> getAllTeachers();
}
