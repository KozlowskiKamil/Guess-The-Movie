import java.util.*;
import java.io.*;

public class Game {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("movies.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.nextLine());
        }
        s.close();
        int random = (int) (Math.random() * list.size());
        System.out.println("Random movie: " + list.get(random));
        String movie = list.get(random);
        String guess = movie.replaceAll("[a-zA-Z]", "_");
        System.out.println(guess);

        Scanner scanner = new Scanner(System.in);
        int attempts = 3;
        Set<Character> guesses = new HashSet<>();
        while (attempts > 0) {
            System.out.println("Enter a letter:");
            String input = scanner.nextLine();
            char letter = input.charAt(0);
            if (guesses.contains(letter)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }
            guesses.add(letter);
            if (movie.indexOf(letter) != -1) {
                System.out.println("You guessed correctly: " + letter);
                for (int i = 0; i < movie.length(); i++) {
                    if (movie.charAt(i) == letter) {
                        guess = guess.substring(0, i) + letter + guess.substring(i + 1);
                    }
                }
                System.out.println(guess);
                if (!guess.contains("_")) {
                    System.out.println("Congratulations, you won!");
                    break;
                }
            } else {
                attempts--;
                System.out.println("That letter is not in the movie title. You have " + attempts + " attempts left.");
            }
        }
        if (attempts == 0) {
            System.out.println("You ran out of attempts. The movie was: " + movie);
        }
    }
}
