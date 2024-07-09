package com.ganeshgc.quizservice.service.impl;

import com.ganeshgc.quizservice.entities.QuizEntity;
import com.ganeshgc.quizservice.reository.QuizRepository;
import com.ganeshgc.quizservice.service.QuestionClient;
import com.ganeshgc.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;
    private QuestionClient questionClient;
    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }
    @Override
    public List<QuizEntity> getQuizList() {
        List<QuizEntity> quizEntities = quizRepository.findAll();
        List<QuizEntity> newQuizList = quizEntities.stream()
                .map(quiz -> {
                    quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public QuizEntity getQuiz(int id) {
        QuizEntity quizEntity=quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found :: "+id));
        quizEntity.setQuestions(questionClient.getQuestionsOfQuiz(quizEntity.getId()));
        return quizEntity ;
    }
    @Override
    public void addQuiz(QuizEntity quiz) {
        quizRepository.save(quiz);
    }
}
