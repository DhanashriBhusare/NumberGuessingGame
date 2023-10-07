import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1; // Change this to set the lower bound of the range
        int upperBound = 100; // Change this to set the upper bound of the range
        int maxAttempts = 10; // Change this to set the maximum number of attempts
        
        int score = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;
            
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            
            while (numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfTries++;
                
                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number within the specified range.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                    score++;
                    break;
                }
            }
            
            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}
