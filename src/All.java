/* All class extends the Search class and implements the searchElements() method
 The searchElements() method implements the "ALL" matching strategy by performing a search
 in the people map for the string specified by the user. If the search string is found in the value
 of the map, it adds the value to an ArrayList of matching strings. The ArrayList is then printed,
 along with the number of matching strings found.*/

package search;

import java.util.ArrayList;

import static search.Main.people;

public class All extends Search {
    public void searchElements() {
        ArrayList<String> list = new ArrayList<>();
        int n = 0;
        String dataToSearch = inputSearch();
        for (int i = 0; i < people.size(); i++) {
            // Check if the dataToSearch matches the entire value of the map
            if (people.get(i).equalsIgnoreCase(dataToSearch)) {
                list.add(people.get(i));
                n++;
            }
        }

        if (n != 0) {
            System.out.println(n + " people founded:");
            list.forEach(System.out::println);
        } else System.out.println("No matching people found.");
    }

}
