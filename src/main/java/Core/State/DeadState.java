package Core.State;

import Core.GameData;
import Core.IO.Input;
import Core.IO.Output;

public class DeadState implements State {
    @Override
    public void execute() {
        GameData.setPoints(0);
        Output.printLost();
        String input = Input.requestInput(GameData.scanner);

        while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            System.out.println(!input.equalsIgnoreCase("y"));
            input = Input.requestInput(GameData.scanner);
        }

        if (input.equalsIgnoreCase("y")) {
            next();
        } else {
            GameData.scanner.close();
        }
    }

    @Override
    public void next() {
        new LoadGameState().execute();
    }
}
