package com.institute.dao;

import com.institute.models.Course;
import java.util.List;

public interface CourseDAO {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    Course getCourse(int courseId);
    List<Course> getAllCourses();
}
