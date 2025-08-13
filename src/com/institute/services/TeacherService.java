package com.institute.services;

import com.institute.dao.TeacherDAO;
import com.institute.dao.TeacherDAOImpl;
import com.institute.models.Teacher;
import java.util.List;

public class TeacherService {
    private TeacherDAO teacherDAO;

    public TeacherService() {
        this.teacherDAO = new TeacherDAOImpl();
    }

    public void addTeacher(Teacher teacher) {
        // Add business logic here, e.g., validation
        teacherDAO.addTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        // Add business logic here
        teacherDAO.updateTeacher(teacher);
    }

    public void deleteTeacher(int teacherId) {
        // Add business logic here
        teacherDAO.deleteTeacher(teacherId);
    }

    public Teacher getTeacher(int teacherId) {
        return teacherDAO.getTeacher(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
}
