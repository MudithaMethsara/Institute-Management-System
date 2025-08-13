package com.institute.services;

import com.institute.dao.ExamResultDAO;
import com.institute.dao.ExamResultDAOImpl;
import com.institute.models.ExamResult;
import java.util.List;

public class ExamResultService {
    private ExamResultDAO examResultDAO;

    public ExamResultService() {
        this.examResultDAO = new ExamResultDAOImpl();
    }

    public void addExamResult(ExamResult examResult) {
        // Add business logic here, e.g., validation
        examResultDAO.addExamResult(examResult);
    }

    public void updateExamResult(ExamResult examResult) {
        // Add business logic here
        examResultDAO.updateExamResult(examResult);
    }

    public void deleteExamResult(int examResultId) {
        // Add business logic here
        examResultDAO.deleteExamResult(examResultId);
    }

    public ExamResult getExamResult(int examResultId) {
        return examResultDAO.getExamResult(examResultId);
    }

    public List<ExamResult> getExamResultsForStudent(int studentId) {
        return examResultDAO.getExamResultsForStudent(studentId);
    }
}
