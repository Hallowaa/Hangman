package Core.State;

import Core.GameData;
import IO.Input;
import IO.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuessWordState implements State {
    @Override
    public void execute() {
        String wordToGuess = GameData.getCurrentWord();
        int currentTries = 0;
        boolean[] guessedPositions = new boolean[wordToGuess.length()];
        List<Character> guessedCharacters = new ArrayList<>();
        Arrays.fill(guessedPositions, false);
        while(currentTries < GameData.getMaxTries() && !wordIsGuessed(guessedPositions)) {
            Output.formatConsole(wordToGuess, guessedPositions);

            String guess = Input.requestInput();
            if (guess.length() > 1) {

            }
        }
    }

    private boolean wordIsGuessed(boolean[] positions) {
        boolean result = true;
        for (boolean position : positions) {
            if (!position) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void next() {

    }
}
