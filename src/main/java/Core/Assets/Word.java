package Core.Assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for storing and performing different operations on a word.
 */
public class Word {

    private final String text;
    private final boolean[] guessedPositions;

    public Word(String text) {
        this.text = text;
        this.guessedPositions = new boolean[text.length()];
        Arrays.fill(guessedPositions, false);
    }

    public String getText() {
        return text;
    }

    /**
     * Returns a formatted version of the word. Guessed positions of the word are revealed, and non-guessed
     * positions are replaced by "_ ".
     * @return A formatted version of the word.
     */
    public String format() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (guessedPositions[i]) {
                result.append(text.charAt(i)).append(" ");
            } else {
                result.append("_ ");
            }
        }

        return result.toString();
    }

    public int length() {
        return text.length();
    }

    public boolean contains(String text) {
        return this.text.contains(text);
    }

    public List<Integer> getPositionsOfChar(Character character) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < text.toCharArray().length; i++) {
            if (character == text.charAt(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public void addGuessedPositions(List<Integer> positions) {
        for (Integer position : positions) {
            if (position >= 0 && position < guessedPositions.length) {
                guessedPositions[position] = true;
            }
        }
    }

    public boolean isGuessed() {
        boolean result = true;
        for (boolean position : guessedPositions) {
            if (!position) {
                result = false;
                break;
            }
        }
        return result;
    }
}
