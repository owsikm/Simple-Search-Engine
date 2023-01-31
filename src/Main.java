package search;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Map to store the data read from file
    static Map<Integer, String> people = new HashMap<>();
    // File to read data from
    static File input;

    public static void main(String[] args) {
        // Check if the first argument is "--data" and store the second argument as file path
        if (args[0].equals("--data")) {
            input = new File(args[1]);
        }
        // Read data from the file
        readFile();
        // Display menu options to user
        menu();
    }

    static void menu() {
        // Display menu options to user
        System.out.println("""
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit""");

        // Scan input from user
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        // Perform action based on user input
        switch (option) {
            case 1 -> {
                // Call function to select search strategy
                selectStrategy();
                // Display menu options to user
                menu();
            }
            case 2 -> {
                // Call function to print all people data
                printAll();
                // Display menu options to user
                menu();
            }
            case 0 -> {
                // Exit the program
                System.out.println("Bye!");
                System.exit(0);
            }
            default -> {
                // Handle invalid input
                System.out.println("Incorrect option! Try again.\n");
                // Display menu options to user
                menu();
            }
        }
    }

    // Function to select search strategy
    static void selectStrategy() {
        // Ask user to select a strategy
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        // Scan input from user
        Scanner scanner = new Scanner(System.in);
        String strategy = scanner.nextLine();
        // Initialize search type
        Search searchType =null;
        // Check the selected strategy and create an object of the corresponding type
        if ("ALL".equalsIgnoreCase(strategy)) {
            searchType = new All();
        } else if ("ANY".equalsIgnoreCase(strategy)) {
            searchType = new Any();
        } else if ("NONE".equalsIgnoreCase(strategy)) {
            searchType = new None();
        } else {
            // Handle invalid input
            System.out.println("Error!");
            System.exit(0);
        }
        // Call the search method
        searchType.search();
    }

    // Function to print all people data
    static void printAll() {
        // Iterate through the map and print all values
        people.forEach((key, value) -> System.out.println(value));
        // Add new line for readability
        System.out.println();
    }

// readFile() method is reading the file specified in the input variable
// and storing its contents in the people map, where the key is an incrementing integer and
// the value is a line of the file

    static void readFile() {
        int i = 0;
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                people.put(i, line);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + input);
        }

    }
}
