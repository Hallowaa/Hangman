package Art;

public enum Frames {
    FRAME_1("╔═════╦═════╗%n      ║%n      ║%n"),
    FRAME_2("╔═════╦═════╗%n      ║%n      ║%n    -----%n    |. .|%n    -----%n"),
    FRAME_3("╔═════╦═════╗%n      ║%n      ║%n    -----%n    |. .|%n    -----%n ──── | %n"),
    FRAME_4("╔═════╦═════╗%n      ║%n      ║%n    -----%n    |. .|%n    -----%n ──── | ────%n"),
    FRAME_5("╔═════╦═════╗%n      ║%n      ║%n    -----%n    |. .|%n    -----%n ──── | ────%n      |%n     /%n    /%n"),
    FRAME_6("╔═════╦═════╗%n      ║%n      ║%n    -----%n    |. .|%n    -----%n ──── | ────%n      |%n     / \\%n    /   \\%n");


    private String frame;
    Frames(String frame) {
        this.frame = frame;
    }

    public String getFrame() {
        return frame;
    }
}
