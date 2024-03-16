import java.util.*;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        while (true) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ". Guess it!");

            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + generatedNumber);
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nGame Over. Your total score: " + score);
                break;
            }
        }

        scanner.close();
    }
}
