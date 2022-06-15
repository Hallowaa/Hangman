package IO;

public final class Output {
    private Output() {}

    public static void greetPlayer() {
        System.out.println("Hello, lovely player!");
        System.out.println("Today, we are playing a simple, yet morbidus game: Hangman!");
    }

    public static void loadingWords() {
        System.out.println("Loading words...");
    }

    public static void wordsLoaded() {
        System.out.println("Words loaded!");
    }

    public static void fakeClearConsole(int enters) {
        for (int i = 0; i < enters; i++) {
            System.out.println();
        }
    }

    public static void fakeClearConsole() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    public static void formatConsole(String word, boolean[] guessed) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                result.append(word.charAt(i));
            } else {
                result.append("_");
            }
        }

        System.out.println(result);
    }

    public void requestCharOrWord() {
        System.out.println("Guess a character or the whole word!");
    }
}
