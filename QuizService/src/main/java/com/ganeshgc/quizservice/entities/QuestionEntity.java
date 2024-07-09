package com.ganeshgc.quizservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {

    private int id;
    private String question;
    private int quizId;
}
