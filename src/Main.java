import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Operations {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("movies.txt"));
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        List<Character> guess = new ArrayList<>();
        while (s.hasNext()) {
            list.add(s.nextLine());
        }
        s.close();
        int random = (int) (Math.random() * list.size());
        System.out.println("\nOdgadnij tytuł filmu wprowadzając litery i znaki z klawiatury.");
        System.out.println("Pamiętaj znaki jak spacja czy apostrof również musisz odgadnąć to nie wada a cecha programu.:) ");
        System.out.println("\nLosowy tytuł filmu ma tyle znaków co podkreślników ");
        //  System.out.println( "\nLosowy tytuł filmu ma tyle znaków co podkreślników " +  list.get(random));
        movie = list.get(random);
        String replace = movie;
        //replace = replace.replaceAll("[a-zA-Z]", "_");

        underscor(guess, replace);
        int i = 10;
        while (i > 0) {
            System.out.println("\nMasz: " + i + " prób na odgadnięcie filmu");
            if (!inputChar(scanner, guess, replace)) {
                i--;
            }
            if (underscor(guess, replace)) {
                break;
            }

        }
        System.out.println("\nTytuł filmu to : " + movie);

    }

}

