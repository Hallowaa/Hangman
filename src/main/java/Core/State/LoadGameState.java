package Core.State;

import Core.GameData;
import Core.IO.Output;

import java.io.File;
import java.io.IOException;

public class LoadGameState implements State {
    @Override
    public void execute() {
        Output.loadingWords();
        try {
            GameData.loadWords(new File("src/main/resources/wordlist.json"));
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
