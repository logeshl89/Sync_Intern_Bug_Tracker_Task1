package com.example.sync_intern_bug_tracker;

import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        int min = 1; // minimum value of the range
        int max = 100; // maximum value of the range
        int secretNumber;
        int guess;
        int attempts;
        int score;
        String playAgain;

        do {
            secretNumber = new Random().nextInt(max - min + 1) + min; // generate a random number in the range
            attempts = 0;
            score = 100;
            do {
                guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Guess the number between " + min + " and " + max));
                attempts++;

                if (guess == secretNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations, you guessed the number in " + attempts + " attempts!\nYour score is " + score + ".");
                } else if (guess < secretNumber) {
                    JOptionPane.showMessageDialog(null, "The secret number is greater than " + guess + ".");
                    score -= 10; // decrease the score by 10 points for a wrong guess
                } else {
                    JOptionPane.showMessageDialog(null, "The secret number is lower than " + guess + ".");
                    score -= 10; // decrease the score by 10 points for a wrong guess
                }
            } while (guess != secretNumber && attempts < 7); // limit the number of attempts to 7

            if (attempts == 7) {
                JOptionPane.showMessageDialog(null, "Sorry, you have used up all your attempts.\nThe secret number was " + secretNumber + ".");
            }

            playAgain = JOptionPane.showInputDialog(null, "Do you want to play again? (y/n)").toLowerCase();
        } while (playAgain.equals("y"));

        JOptionPane.showMessageDialog(null, "Thank you for playing!");
    }
}


