package Core.State;

import Core.GameData;

public interface State {
    void execute();
    void next();
}
