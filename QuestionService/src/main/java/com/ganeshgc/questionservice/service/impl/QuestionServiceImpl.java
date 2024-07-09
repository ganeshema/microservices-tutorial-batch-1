package com.ganeshgc.questionservice.service.impl;

import com.ganeshgc.questionservice.entities.QuestionEntity;
import com.ganeshgc.questionservice.repository.QuestionsRepository;
import com.ganeshgc.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Override
    public List<QuestionEntity> questionList() {
        List<QuestionEntity> listOfQuestions=questionsRepository.findAll();
        return listOfQuestions;
    }

    @Override
    public QuestionEntity findQuestionById(int id) {
        QuestionEntity questionEntity=questionsRepository.findById(id).orElseThrow(()->new RuntimeException("the question is not found with id: : "+id));
        return questionEntity;
    }

    @Override
    public List<QuestionEntity> findQuestionsByQuizId(int quizId) {
        List<QuestionEntity> questionEntities=questionsRepository.findAllByQuizId(quizId);
        return questionEntities;
    }

    @Override
    public void addQuestion(QuestionEntity question) {
        questionsRepository.save(question);
    }
}
