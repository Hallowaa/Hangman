package Core.State;

import Core.GameData;
import Core.IO.Output;

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
