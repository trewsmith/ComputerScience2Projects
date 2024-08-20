//Trew Smith
//AI Wordle
//5-22-24

import java.util.Scanner;

public class Main {
    private static final String SECRET_WORD = "apple";
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        playWordle();
    }

    public static void playWordle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Wordle! You have 6 attempts to guess a 5-letter word.");

        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            attempts++;
            System.out.println("Attempt #" + attempts + ":");
            String guess = scanner.nextLine().toLowerCase();
            
            
            
            if (guess.equals(SECRET_WORD)) {
                System.out.println("Congratulations! You guessed the word correctly: " + SECRET_WORD);
                break;
            } else if(guess.length() == 5) {
                String feedback = getFeedback(guess);
                System.out.println("Feedback: " + feedback);
            }
            else {
                System.out.println("Sorry, that guess doesn't have 5 letters. ");
                attempts = attempts - 1;
                //this line was added to the AI program to ensure that the guesses were 5 letters long. Previously, you could input a word with any amount of letters
                //adding another attempt if they don't input a 5 letter word ensures that all the attempts are valid
            }
            

            
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've run out of attempts! The word was: " + SECRET_WORD);
        }

        scanner.close();
    }

    public static String getFeedback(String guess) {
        StringBuilder feedback = new StringBuilder();
        //The StringBuilder class is a class we haven't covered. It offers an alternative to strings which cannot be changed by allowing strings to be altered, but it provides no guarantee of synchronization, the StringBuilder() puts an intial limit of 16 characters, but you can specify a different limit to the length of an integer, CharSequence, or String

        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char secretChar = SECRET_WORD.charAt(i);

            if (guessChar == secretChar) {
                feedback.append(guessChar);
            } else if (SECRET_WORD.indexOf(guessChar) != -1) {
                feedback.append("+");
            } else {
                feedback.append("-");
            }
        }

        return feedback.toString();
    }
}
