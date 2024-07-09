package com.ganeshgc.questionservice.repository;

import com.ganeshgc.questionservice.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionEntity,Integer> {
    List<QuestionEntity> findAllByQuizId(int quizId);

}
