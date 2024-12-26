import java.util.Random;
import java.util.Scanner;

public class Number_Game{
public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int score = 0;
	        String playAgain = "yes";

	        while (playAgain.equalsIgnoreCase("yes")) {
	            int numberToGuess = random.nextInt(100) + 1; 
	            int attempts = 0;
	            int maxAttempts = 5;
	            int guess = -1;

	            System.out.println("I have generated a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

	            while (attempts < maxAttempts) 
	            {
	                System.out.print("Enter your guess number: ");
	                guess = scanner.nextInt();
	                attempts++;

	                if (guess == numberToGuess) 
	                {
	                    System.out.println("Correct! The number was " + numberToGuess + ".");
	                    score++;
	                    break;
	                } 
	                else if (guess < numberToGuess) 
	                {
	                    System.out.println("Too low!");
	                } else 
	                {
	                    System.out.println("Too high!");
	                }
	            }

	            if (guess != numberToGuess) {
	                System.out.println("Sorry, the number was " + numberToGuess + ".");
	            }

	            System.out.println("Your score: " + score);
	            System.out.print("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next();
	        }

	        System.out.println("Thanks for playing! Your final score is " + score + ".");
	        scanner.close();
	    }
        }