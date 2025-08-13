package com.institute.dao;

import com.institute.models.ExamResult;
import java.util.List;

public interface ExamResultDAO {
    void addExamResult(ExamResult examResult);
    void updateExamResult(ExamResult examResult);
    void deleteExamResult(int examResultId);
    ExamResult getExamResult(int examResultId);
    List<ExamResult> getExamResultsForStudent(int studentId);
}
