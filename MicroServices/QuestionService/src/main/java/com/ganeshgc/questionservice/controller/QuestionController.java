package com.ganeshgc.questionservice.controller;

import com.ganeshgc.questionservice.entities.QuestionEntity;
import com.ganeshgc.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping
    public List<QuestionEntity> getAllQuestions() {
       return questionService.questionList();
    }
    @GetMapping("/{id}")
    public QuestionEntity getQuestionById(@PathVariable int id) {
        return questionService.findQuestionById(id);
    }
    @GetMapping("/quiz/{quizId}")
    public List<QuestionEntity> getQuestionByQuizId(@PathVariable int quizId) {
        return questionService.findQuestionsByQuizId(quizId);

    }
    @PostMapping
    public QuestionEntity createQuestion(@RequestBody QuestionEntity question) {
        questionService.addQuestion(question);
        return question;
    }
}
