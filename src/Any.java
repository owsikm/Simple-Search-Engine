package search;

import java.util.ArrayList;
import static search.Main.people;

public class Any extends Search {
    //search method implementation for Any search
    public void searchElements() {
        //list to store matching people
        ArrayList<String> list = new ArrayList<>();
        //array to store the elements of dataToSearch separated by space
        String[] elementsToSearch = new String[0];
        //number of matching people found
        int n = 0;
        //input data to search
        String dataToSearch = inputSearch();
        //splitting input data by space
        for (int i = 0; i < dataToSearch.length(); i++) {
            elementsToSearch = dataToSearch.split(" ");
        }
        //iterating over all people in the list
        for (int i = 0; i < people.size(); i++) {
            //splitting each person name by space
            String[] words = people.get(i).split("\\s+");
            //iterating over each word in person name
            for (String word : words) {
                //iterating over elements in elementsToSearch
                for (String toSearch : elementsToSearch) {
                    //comparing each element with the word
                    if (toSearch.equalsIgnoreCase(word)) {
                        //adding the matching person to the list if it's not already present
                        if (!list.contains(people.get(i))) {
                            list.add(people.get(i));
                            n++;
                        }
                    }
                }
            }
        }
        //printing the results
        if (n != 0) {
            System.out.println(n + " people founded:");
            list.forEach(System.out::println);
        } else System.out.println("No matching people found.");
    }

}
