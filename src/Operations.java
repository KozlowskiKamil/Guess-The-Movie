import java.util.List;
import java.util.Scanner;

public class Operations {
    public static String movie;

    public static char leter;

    public static boolean inputChar(Scanner scanner, List<Character> guess, String replace) {
        System.out.println("\nWprowadź literę do odgadnięcia filmu");
        String input = scanner.nextLine();
        guess.add(input.charAt(0));
        return movie.contains(input);

    }

    public static boolean underscor(List<Character> guess, String movie) {
        boolean guesses = true;

        for (int i = 0; i < movie.length(); i++) {
            leter = movie.charAt(i);


            if (guess.contains(leter)) {
                System.out.print(leter);
            } else {
                System.out.print("_");
                guesses = false;

            }

        }
        if (guesses) {
            System.out.println("\nGratulacje wygrałeś");


        }
        return guesses;
    }

}


