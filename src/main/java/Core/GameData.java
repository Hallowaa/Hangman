package Core;

import Art.Frames;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class GameData {
    private GameData() {}

    private static List<String> words = new ArrayList<>();
    private static boolean wordsLoaded = false;
    private static String currentWord = "";
    private static final int maxTries = Frames.values().length;
    public static final Scanner scanner = new Scanner(System.in);
    private static int points = 0;

    public static void loadWords(File file) throws IOException {
        WordParser parser = new WordParser();
        words = parser.parseWords(file);
        wordsLoaded = true;
    }

    public static void getNextWord() {
        if (wordsLoaded) {
            if (!currentWord.equals("")) words.remove(currentWord);
            currentWord = words.get(new Random().nextInt(0, words.size() - 1));
        } else {
            throw new IllegalStateException("Error, words not loaded yet!");
        }
    }

    public static String getCurrentWord() {
        return currentWord;
    }

    public static int getMaxTries() {
        return maxTries;
    }

    public static void increasePoints(int amount) {
        points += amount;
    }

    public static void setPoints(int points) {
        GameData.points = points;
    }

    public static int getPoints() {
        return points;
    }
}
