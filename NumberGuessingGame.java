import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playNumberGuessingGame(scanner);
    }

    private static void playNumberGuessingGame(Scanner scanner) {
        int lowerLimit = 0;
        int upperLimit = 100;
        int randomNumber = generateRandomNumber(lowerLimit, upperLimit);

        int maxAttempts = 5;  // You can adjust the maximum number of attempts
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");

            while (attempts < maxAttempts) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.println("Current Score: " + score);
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();

            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Your final score is: " + score);
            } else {
                randomNumber = generateRandomNumber(lowerLimit, upperLimit);
                attempts = 0;
            }
        }
    }

    private static int generateRandomNumber(int lower, int upper) {
        return lower + (int) (Math.random() * (upper - lower + 1));
    }
}
