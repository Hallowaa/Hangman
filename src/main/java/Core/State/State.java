package Core.State;

/**
 * Interface for States. States define the flow of the game.
 */
public interface State {
    void execute();
    void next();
}
