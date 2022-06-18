package Core.State;

import Core.GameData;
import Core.IO.Output;

import java.io.IOException;
import java.io.InputStream;

/**
 * State for loading the game's assets, such as words.
 */
public class LoadGameState implements State {
    @Override
    public void execute() {
        Output.loadingWords();
        try {
            InputStream in = LoadGameState.class.getResourceAsStream("/Words.json");
            GameData.loadWords(in);
        } catch (IOException e) {
            Output.print("Error while loading words. Perhaps 'Words.json' is missing or has been renamed.");
        }
        Output.wordsLoaded();
        Output.greetPlayer();
        next();
    }

    @Override
    public void next() {
        new GuessWordState().execute();
    }
}
