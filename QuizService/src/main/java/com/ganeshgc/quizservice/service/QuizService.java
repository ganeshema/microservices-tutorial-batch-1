package com.ganeshgc.quizservice.service;

import com.ganeshgc.quizservice.entities.QuizEntity;

import java.util.List;

public interface QuizService {

    List<QuizEntity> getQuizList();
    QuizEntity getQuiz(int id);
    void addQuiz(QuizEntity quiz);
}
