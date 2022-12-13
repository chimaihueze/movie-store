import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    // movie list
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process Complete\n\n");
        }


    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */

    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.\n");
            String response = scan.nextLine();

            if (response.equalsIgnoreCase("a")) {
                System.out.print("\tName of the movie you want to buy: ");
                String name = scan.nextLine();
                // Sell movie
                store.action(name, "sell");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
            }

            else if (response.equalsIgnoreCase("b")) {
                System.out.print("\tName of the movie you want to rent: ");
                String name = scan.nextLine();
                // rent movie
                store.action(name, "rent");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
            }

            else if (response.equalsIgnoreCase("c")) {
                System.out.print("\tName of the movie you want to return: ");
                String name = scan.nextLine();
                // return movie
                store.action(name, "return");
                System.out.println("\n\nUPDATED MOVIES\n\n");
                System.out.println(store);
            }

            else {
                break;
            }
        }
    }

    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */


    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);

        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String [] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        } scanFile.close();
    }
}
