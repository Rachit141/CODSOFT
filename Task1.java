import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Game!");
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI'm thinking of a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            int attempts = 0;
            boolean isCorrect = false;

            while (attempts < maxAttempts && !isCorrect) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    isCorrect = true;
                    score += maxAttempts - attempts + 1;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!isCorrect) {
                System.out.println("\nSorry, you ran out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("\nThank you for playing! Your total score is: " + score);
            }
        }

        scanner.close();
    }
}
