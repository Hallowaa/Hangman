package Core.State;

import Core.GameData;
import Core.IO.Input;
import Core.IO.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuessWordState implements State {

    private int currentFails = 0;

    @Override
    public void execute() {
        GameData.getNextWord();
        String wordToGuess = GameData.getCurrentWord();
        boolean[] guessedPositions = new boolean[wordToGuess.length()];
        List<Character> guessedCharacters = new ArrayList<>();
        Arrays.fill(guessedPositions, false);
        char lastGuessed = ' ';
        boolean lastGuessedAlreadyGuessed = false;

        while(currentFails < GameData.getMaxTries() && !wordIsGuessed(guessedPositions)) {
            Output.printArt(currentFails);

            if (lastGuessedAlreadyGuessed) {
                Output.printCharAlreadyGuessed(lastGuessed);
                lastGuessedAlreadyGuessed = false;
            }

            Output.formatWord(wordToGuess, guessedPositions);

            if (!guessedCharacters.isEmpty())
                Output.printGuessedChars(guessedCharacters);

            Output.requestCharOrWord();
            String guess = Input.requestInput(GameData.scanner);

            if (guess.length() > 1 && !guess.equals(wordToGuess)) {
                currentFails++;
            } else if (guess.equals(wordToGuess)) {
                next();
            } else if (guess.length() == 1) {
                if (guessedCharacters.contains(guess.charAt(0))) {
                    lastGuessedAlreadyGuessed = true;
                } else if (wordToGuess.contains(guess)) {
                    for (Integer position : findCharPositionInWord(wordToGuess, guess.charAt(0))) {
                        guessedPositions[position] = true;
                    }
                    guessedCharacters.add(guess.charAt(0));
                } else {
                    currentFails++;
                    guessedCharacters.add(guess.charAt(0));
                }

                lastGuessed = guess.charAt(0);
            }
            Output.clearConsole();
        }

        next();
    }
    
    private List<Integer> findCharPositionInWord(String word, char character) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < word.toCharArray().length; i++) {
            if (character == word.charAt(i)) {
                result.add(i);
            }
        }
        return result;
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
        if (currentFails == GameData.getMaxTries()) {
            new DeadState().execute();
        } else {
            new WonState().execute();
        }
    }
}
