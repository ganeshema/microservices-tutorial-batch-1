package com.ganeshgc.questionservice.service;

import com.ganeshgc.questionservice.entities.QuestionEntity;

import java.util.List;

public interface QuestionService {
    List<QuestionEntity> questionList();
    QuestionEntity findQuestionById(int id);
    List<QuestionEntity> findQuestionsByQuizId(int quizId);
    void addQuestion(QuestionEntity question);

}
