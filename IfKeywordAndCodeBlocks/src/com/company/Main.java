package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

//        if(score == 5000) {
//            System.out.println("Your score was 5000");
//        }
//        if(score < 5000) {
//            System.out.println("Your score was less than 5000");
//        } else {
//            System.out.println("Got here");
//        }
//        if(score <= 5000) {
//            System.out.println("Your score was less than 5000");
//        } else {
//            System.out.println("Got here");
//
//        }
//        if(score < 5000 && score > 1000) {
//            System.out.println("Your score was less than 5000 but greater than 1000");
//        } else if(score < 1000) {
//            System.out.println("Your score was less than 1000");
//        } else {
//            System.out.println("Got here");
//        }
        if(gameOver == true) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
//        boolean gameStart = true;
//        int secondScore = 10000;
//        int secondLevelCompleted = 8;
//        int secondBonus = 200;
//
//        if(gameStart) {
//            int finalScore = secondScore + (secondLevelCompleted * secondBonus);
//            System.out.println("Your second final score was " + finalScore);
//        }

        // Can still use the int finalScore in the second block,
        // because as soon as the first code block is finished, Java will automatically delete what is in the first code block.

        //SECOND WAY OF DOING IT: Duplication, not recommended
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if(gameOver == true) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
    }
}  }

