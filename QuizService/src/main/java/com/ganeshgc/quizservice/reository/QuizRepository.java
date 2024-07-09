package com.ganeshgc.quizservice.reository;

import com.ganeshgc.quizservice.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity,Integer> {

}
