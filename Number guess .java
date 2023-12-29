import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                roundsWon++;
                System.out.println("You won this round!");
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score: Rounds Won: " + roundsWon + " out of " + totalRounds);
        scanner.close();
    }
}