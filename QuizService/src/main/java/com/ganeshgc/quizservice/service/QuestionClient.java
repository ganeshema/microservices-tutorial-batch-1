package com.ganeshgc.quizservice.service;

import com.ganeshgc.quizservice.entities.QuestionEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
//@FeignClient(url = "http://localhost:8082", value = "Question-Client")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    public List<QuestionEntity> getQuestionsOfQuiz(@PathVariable int quizId);
}

