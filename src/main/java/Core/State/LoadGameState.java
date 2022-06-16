package Core.State;

import Core.GameData;
import Core.IO.Output;

import java.io.IOException;
import java.io.InputStream;

public class LoadGameState implements State {
    @Override
    public void execute() {
        Output.loadingWords();
        try {
            InputStream in = LoadGameState.class.getResourceAsStream("/Words.json");
            GameData.loadWords(in);
        } catch (IOException e) {
            e.printStackTrace();
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
