package com.quiz.create;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String quizTitle;
    private List<Question> questions;


    public Quiz(String quizTitle){
        this.quizTitle=quizTitle;
        this.questions=new ArrayList<>();
    }
     public void addQuestion(Question question){
        questions.add(question);
     }

     public List<Question> getQuestions(){
        return questions;
     }

    public String getQuizTitle() {
        return quizTitle;
    }
}
