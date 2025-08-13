package com.institute.services;

import com.institute.dao.CourseDAO;
import com.institute.dao.CourseDAOImpl;
import com.institute.models.Course;
import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAOImpl();
    }

    public void addCourse(Course course) {
        // Add business logic here, e.g., validation
        courseDAO.addCourse(course);
    }

    public void updateCourse(Course course) {
        // Add business logic here
        courseDAO.updateCourse(course);
    }

    public void deleteCourse(int courseId) {
        // Add business logic here
        courseDAO.deleteCourse(courseId);
    }

    public Course getCourse(int courseId) {
        return courseDAO.getCourse(courseId);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
}
