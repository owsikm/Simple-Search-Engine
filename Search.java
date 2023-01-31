package search;

import java.util.Scanner;

// Abstract class for searching elements
public abstract class Search {

    // Method to get user input for data to be searched
    public String inputSearch() {
        System.out.println("Enter data to search people:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Method to perform the search
    public void search() {
        searchElements();
    }

    // Abstract method to be implemented by subclasses
    public abstract void searchElements();
}