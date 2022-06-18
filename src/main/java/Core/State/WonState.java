package Core.State;

import Core.GameData;
import Core.IO.Output;

/**
 * State for when the player has guessed a word correctly during {@link GuessWordState}. Points are granted
 * and the player begins to guess a new word.
 */
public class WonState implements State {
    @Override
    public void execute() {
        GameData.increasePoints(GameData.getCurrentWord().length());
        Output.printGainedPoints(GameData.getCurrentWord().length());
        Output.printCurrentPoints(GameData.getPoints());
        next();
    }

    @Override
    public void next() {
        new GuessWordState().execute();
    }
}
