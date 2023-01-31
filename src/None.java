package search;

import java.util.ArrayList;

import static search.Main.people;

public class None extends Search {
    public void searchElements() {

        // Define an ArrayList to store people who do not match search criteria
        ArrayList<String> list = new ArrayList<>();

        // Store search elements in elementsToSearch array
        String[] elementsToSearch = new String[0];
        int n = 0;

        // Get data to be searched
        String dataToSearch = inputSearch();

        // Split data to be searched into separate elements
        for (int i = 0; i < dataToSearch.length(); i++) {
            elementsToSearch = dataToSearch.split(" ");
        }

        // Iterate through all people in people ArrayList
        for (int i = 0; i < people.size(); i++) {
            // Add the person to list
            list.add(people.get(i));
            n++;

            // Split the person's name into words
            String[] words = people.get(i).split("\\s+");
            // Iterate through each word in the person's name
            for (String word : words) {
                // Iterate through elementsToSearch array
                for (String toSearch : elementsToSearch) {
                    // Check if word matches any of the elements in elementsToSearch
                    if (toSearch.equalsIgnoreCase(word)) {
                        // Remove the person from list if word matches
                        list.remove(people.get(i));
                        n--;
                    }
                }
            }
        }

        // Check if there are any people in list
        if (n != 0) {
            // Print the number of people found
            System.out.println(n + " people founded:");
            // Print the names of people found
            list.forEach(System.out::println);
        } else {
            // Print message if no matching people found
            System.out.println("No matching people found.");
        }
    }
}
