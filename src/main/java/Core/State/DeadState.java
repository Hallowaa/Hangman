package Core.State;

import Core.GameData;
import Core.IO.Input;
import Core.IO.Output;

/**
 * State for when the player has lost during {@link GuessWordState} by making too many wrong guesses.
 */
public class DeadState implements State {
    @Override
    public void execute() {
        GameData.setPoints(0);
        Output.lostRevealWord(GameData.getCurrentWord().getText());
        Output.printLost();
        String input = Input.requestInput();

        while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            System.out.println(!input.equalsIgnoreCase("y"));
            input = Input.requestInput();
        }

        if (input.equalsIgnoreCase("y")) {
            next();
        } else {
            Input.getScanner().close();
        }
    }

    @Override
    public void next() {
        new LoadGameState().execute();
    }
}
