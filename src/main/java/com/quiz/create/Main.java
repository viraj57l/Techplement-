package com.quiz.create;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuizManager quizManager =new QuizManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nCommands:");
            System.out.println("1. Create Quiz");
            System.out.println("2. Take Quiz");
            System.out.println("3.Exit");
            System.out.println("Enter command: ");
            int command =scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 1:
                    quizManager.createQuiz();
                    break;
                case 2:
                    quizManager.takeQuiz();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command.Please try again.");

            }
        }
    }
}
