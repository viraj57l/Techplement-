package com.quiz.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizManager {
    private List<Quiz> quizzes;
    private Scanner scanner;

    public QuizManager(){
        quizzes=new ArrayList<>();
        scanner =new Scanner(System.in);
    }
    public void createQuiz(){
        System.out.print("Enter quiz title:");
        String title= scanner.nextLine();
        Quiz quiz =new Quiz(title);
        quizzes.add(quiz);
        System.out.println("Quiz created succesfully");

        addQuestionsToQuiz(quiz);
    }

    private void addQuestionsToQuiz(Quiz quiz){
        while(true){
            System.out.print("Enter question text ( or type 'done' on new line to  finish the question): ");

            String firstLine = scanner.nextLine();
            if (firstLine.equalsIgnoreCase("exit")) {
                System.out.println("Exiting question creation...");
                break;
            }
            
            StringBuilder questionText= new StringBuilder();
            String line;

            while(!(line =scanner.nextLine()).equalsIgnoreCase("done")){
              questionText.append(line).append("\n");
            }

            //checking if the question is empty or not
            if(questionText.toString().trim().isEmpty()){
                System.out.println("Question text cannot be empty .Please enter a valid question");
                continue;
            }

            //adding options
             List< String> options =new ArrayList<>();
             for(int i=1; i<=4;i++){
                 System.out.println("Enter option "+ i + ": " );
                 options.add(scanner.nextLine());
             }
            System.out.println("Enter the number of the correct option (1-4):");
             int correctOption =scanner.nextInt()-1;
             scanner.nextLine();
              //adding questions to List
             quiz.addQuestion(new Question(questionText.toString().trim(),options,correctOption));
        }
    }

    public void takeQuiz(){
        if(quizzes.isEmpty()){
            System.out.println("No quizzes available");
            return;
        }
        System.out.println("Available quizzes :");
        for(int i=0; i<quizzes.size();i++){
            System.out.println((i+1) + ". " +quizzes.get(i).getQuizTitle());
        }

        System.out.print("Select a quiz by number: ");
        int quizIndex=getValidIntegerInput() - 1;

        if(quizIndex<0 || quizIndex>=quizzes.size()){
            System.out.println("Invalid quiz number");
            return;
        }

        Quiz quiz =quizzes.get(quizIndex);
        int score=0;

        for(Question question: quiz.getQuestions()){
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for( int i=0;i< options.size();i++){
                System.out.println((i+1)+ ". "+options.get(i));
            }

            System.out.print("Your answer : ");
            int userAnswer = getValidIntegerInput()-1;

            if (userAnswer < 0 || userAnswer >= options.size()) {
                System.out.println("Invalid answer number.");
                continue;
            }

            if(question.isCorrectOptionIndex(userAnswer)){
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("Wrong answer .The correct answer was : "+options.get(question.getCorrectOptionIndex()) );
            }
            System.out.println();
        }
        System.out.println("Quiz completed ! Your score is  :" +score +"/"+ quiz.getQuestions().size());
    }

    private int getValidIntegerInput(){
        while(true){
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }else{
                System.out.print("Invalid input.Please enter a number:");
                scanner.next();
            }
        }
    }
}
