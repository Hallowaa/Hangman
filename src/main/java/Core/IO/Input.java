package Core.IO;

import java.util.Scanner;

/**
 * A collection of methods to collect user input.
 */
public final class Input {
    private Input() {}

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Requests a single line of input from the user. Input is not validated in any way.
     * @return The user's first line of input.
     */
    public static String requestInput() {
        return scanner.nextLine();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
