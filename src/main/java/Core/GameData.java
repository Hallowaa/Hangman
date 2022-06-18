package Core;

import Art.Frames;

import Core.Assets.Word;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Collection of centralized game data, such as all the words, the current word, the maximum amount of tries and how
 * many points the player currently has.
 */
public final class GameData {
    private GameData() {}

    private static List<String> wordsText = new ArrayList<>();
    private static final List<Word> wordsObjects = new ArrayList<>();
    private static boolean wordsLoaded = false;
    private static Word currentWord;
    private static final int maxTries = Frames.values().length;
    private static int points = 0;

    public static void loadWords(InputStream in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Text is parsed and objects are created separately because I don't know how to do both at the same time.
        if (wordsText.isEmpty()) {
            wordsText = objectMapper.readValue(in, new TypeReference<>() {});
        }

        for (String text : wordsText) {
            wordsObjects.add(new Word(text));
        }

        wordsLoaded = true;
    }

    /**
     * Sets {@link GameData#currentWord} to a random word from {@link GameData#wordsObjects} and removes
     * the old word.
     */
    public static void randomizeCurrentWord() {
        if (wordsLoaded) {
            if (currentWord != null) wordsObjects.remove(currentWord);
            currentWord = wordsObjects.get(new Random().nextInt(0, wordsObjects.size() - 1));
        } else {
            throw new IllegalStateException("Error, words not loaded yet!");
        }
    }

    public static Word getCurrentWord() {
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
