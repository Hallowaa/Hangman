package Core.IO;

import Art.Frames;
import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A collection of Output methods to format collections or simply output a specific message.
 */
public final class Output {
    private Output() {}

    public static void print(String text) {
        System.out.printf("%s%n", text);
    }

    public static void greetPlayer() {
        System.out.println("Hello, lovely player!");
        System.out.printf("Today, we are playing a simple, yet morbidus game: Hangman!%n%n");
    }

    public static void loadingWords() {
        System.out.println("Loading words...");
    }

    public static void wordsLoaded() {
        System.out.println("Words loaded!");
    }

    /**
     * Clears the console for Windows and Linux.
     */
    public static void clearConsole() {
        try {
            if (SystemUtils.IS_OS_WINDOWS) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (SystemUtils.IS_OS_LINUX) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            Output.print("Error when clearing the console. Perhaps your OS has not been accounted for yet!");
        }
    }

    public static void printCharAlreadyGuessed(Character character) {
        System.out.printf("%s was already guessed!%n", character);
    }

    /**
     * Prints a specific frame from {@link Frames}.
     * @param frame The frame's index
     */
    public static void printArt(int frame) {
        System.out.printf(Frames.values()[frame].getFrame());
        System.out.printf("%n%n");
    }

    public static void printGuessedChars(List<Character> characters) {
        StringBuilder result = new StringBuilder();
        if (!characters.isEmpty())
        result.append("Guessed characters: ");

        List<String> charListToStringList =
                characters
                .stream()
                .map(character -> Character.toString(character))
                .collect(Collectors.toList());

        result.append(String.join(", ", charListToStringList));

        if (!result.isEmpty())
        System.out.println(result);
    }

    public static void requestCharOrWord() {
        System.out.print("Guess a character or the whole word: ");
    }

    public static void printCurrentPoints(int points) {
        System.out.printf("You currently have %d points!%n", points);
    }

    public static void printGainedPoints(int points) {
        System.out.printf("You just gained %d points%n", points);
    }

    public static void printLost() {
        System.out.print("You lost, wanna play again? (y/n): ");
    }

    public static void lostRevealWord(String word) {
        System.out.printf("The word was %s%n", word);
    }

}
