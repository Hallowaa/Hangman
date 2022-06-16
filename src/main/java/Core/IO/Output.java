package Core.IO;

import Art.Frames;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class Output {
    private Output() {}

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

    public static void fakeClearConsole(int enters) {
        for (int i = 0; i < enters; i++) {
            System.out.println();
        }
    }

    public static void fakeClearConsole() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void formatWord(String word, boolean[] guessed) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                result.append(word.charAt(i));
            } else {
                result.append("_ ");
            }
        }

        System.out.println(result);
    }

    public static void printCharAlreadyGuessed(Character character) {
        System.out.printf("%s was already guessed!%n", character);
    }

    public static void printArt(int frame) {
        System.out.printf(Frames.values()[frame].getFrame());
        System.out.printf("%n%n");
    }

    public static void printGuessedChars(List<Character> characters) {
        StringBuilder result = new StringBuilder();
        result.append("Guessed characters: ");
        List<String> charListToStringList =
                characters
                .stream()
                .map(character -> Character.toString(character))
                .collect(Collectors.toList());

        result.append(String.join(", ", charListToStringList));
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

}
