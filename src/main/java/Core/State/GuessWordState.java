package Core.State;

import Core.Assets.Word;
import Core.GameData;
import Core.IO.Input;
import Core.IO.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * State for when the player is currently guessing a word.
 */
public class GuessWordState implements State {

    private int currentFails = 0;
    private final List<Character> guessedCharacters = new ArrayList<>();
    private char lastGuessed = 0;
    private boolean lastGuessedAlreadyGuessed = false;

    @Override
    public void execute() {
        GameData.randomizeCurrentWord();
        Word currentWord = GameData.getCurrentWord();
        while(currentFails < GameData.getMaxTries() && !currentWord.isGuessed()) {
            Output.printArt(currentFails);

            if (lastGuessedAlreadyGuessed) {
                Output.printCharAlreadyGuessed(lastGuessed);
                lastGuessedAlreadyGuessed = false;
            }

            Output.print(currentWord.format());
            Output.printGuessedChars(guessedCharacters);
            Output.requestCharOrWord();

            String guess = Input.requestInput();

            if (guess.length() > 1 && !guess.equals(currentWord.getText())) {
                currentFails++;

            } else if (guess.equals(currentWord.getText())) {
                // Guessed the whole word
                break;

            } else if (guess.length() == 1) {
                char character = guess.charAt(0);

                if (guessedCharacters.contains(character)) {
                    lastGuessedAlreadyGuessed = true;

                } else if (currentWord.contains(guess)) {
                    currentWord.addGuessedPositions(currentWord.getPositionsOfChar(character));
                    guessedCharacters.add(character);

                } else {
                    currentFails++;
                    guessedCharacters.add(character);
                }

                lastGuessed = character;
            }
            Output.clearConsole();
        }
        next();
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
