import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"programming", "java", "computer", "hangman", "keyboard"};
        Random rand = new Random();
        String wordToGuess = words[rand.nextInt(words.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 6;
        boolean won = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + attempts + " attempts to guess the word.");

        while (attempts > 0 && !won) {
            System.out.println("\nWord to guess: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
                printHangman(attempts);
                System.out.println("Incorrect guess. You have " + attempts + " attempts left.");
            }

            if (String.valueOf(guessedWord).equals(wordToGuess)) {
                won = true;
            }
        }

        if (won) {
            System.out.println("\nCongratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nGame over. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static void printHangman(int attempts) {
        switch (attempts) {
            case 5:
                System.out.println("  O  ");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 4:
                System.out.println("  O  ");
                System.out.println("  |  ");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 3:
                System.out.println("  O  ");
                System.out.println("  |  ");
                System.out.println("  |  ");
                System.out.println();
                System.out.println();
                break;
            case 2:
                System.out.println("  O  ");
                System.out.println(" \\|  ");
                System.out.println("  |  ");
                System.out.println();
                System.out.println();
                break;
            case 1:
                System.out.println("  O  ");
                System.out.println(" \\|/ ");
                System.out.println("  |  ");
                System.out.println();
                System.out.println();
                break;
            case 0:
                System.out.println("  O  ");
                System.out.println(" \\|/ ");
                System.out.println("  |  ");
                System.out.println(" /   ");
                System.out.println();
                break;
            case -1:
                System.out.println("  O  ");
                System.out.println(" \\|/ ");
                System.out.println("  |  ");
                System.out.println(" / \\ ");
                System.out.println();
                break;
            default:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
        }
    }
}
