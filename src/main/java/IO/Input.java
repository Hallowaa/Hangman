package IO;

import java.util.Scanner;

public final class Input {
    private Input() {}


    public static String requestInput() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }

}
