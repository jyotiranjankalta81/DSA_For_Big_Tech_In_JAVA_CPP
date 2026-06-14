package TreeSet;
/*
====================================================
TREESET
====================================================

Stores UNIQUE values

+
Automatically SORTS them

====================================================

HashSet

Unique
No order

Example:

[30,10,20]

====================================================

TreeSet

Unique
Sorted

Example:

[10,20,30]

====================================================
*/

import java.util.*;

public class TreeSetConcept {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        TreeSet<Integer> tset = new TreeSet<>(Arrays.asList(5, 1, 3, 7, 9, 2));
// Internally sorted: [1, 2, 3, 5, 7, 9]

// Navigation operations
        tset.first();          // 1 (smallest)
        tset.last();           // 9 (largest)
        tset.floor(4);         // 3 (largest element <= 4)
        tset.ceiling(4);       // 5 (smallest element >= 4)
        tset.lower(5);         // 3 (strictly less than 5)
        tset.higher(5);        // 7 (strictly greater than 5)
        tset.pollFirst();      // 1 (removes and returns smallest)
        tset.pollLast();       // 9 (removes and returns largest)

// Sub-set operations
        tset.subSet(2, true, 7, true);  // [2, 3, 5, 7]
        tset.headSet(5);                 // [1, 2, 3] (strictly less than 5)
        tset.tailSet(5);                 // [5, 7, 9] (>= 5)
        tset.descendingSet();            // reverse order view

// Custom ordering with Comparator
        TreeSet<String> byLength = new TreeSet<>(
                Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
        );
        byLength.add("banana");
        byLength.add("fig");
        byLength.add("apple");
// Iteration: fig, apple, banana (by length, then alphabetical)
        System.out.println(set);
    }
}