package com.ganeshgc.quizservice.controller;

import com.ganeshgc.quizservice.entities.QuizEntity;
import com.ganeshgc.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public QuizEntity addQuiz(@RequestBody QuizEntity quiz) {
        quizService.addQuiz(quiz);
        return quiz;
    }
    @GetMapping
    public List<QuizEntity> getAllQuiz() {
        return quizService.getQuizList();
    }
    @GetMapping("/{id}")
    public QuizEntity getQuizById(@PathVariable int id) {
        return quizService.getQuiz(id);
    }






}
