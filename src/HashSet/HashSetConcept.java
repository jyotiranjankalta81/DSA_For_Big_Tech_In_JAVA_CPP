/*
====================================================
HASHSET
====================================================

HashSet stores

ONLY UNIQUE VALUES

Duplicates are automatically removed.

====================================================
EXAMPLE
====================================================

Input:

10
20
30
20
10
40

HashSet:

[10,20,30,40]

Duplicate 10 removed
Duplicate 20 removed

====================================================
REAL LIFE
====================================================

Party Entry

People Enter:

Ram
Shyam
Ram
Hari
Shyam

Final Unique People:

Ram
Shyam
Hari

====================================================
*/

package HashSet;

import java.util.*;

public class HashSetConcept {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set3 = new HashSet<>(set2);  // copy constructor

// Add elements
        set.add(1);     // true (added)
        set.add(1);     // false (already present — no duplicate)
        set.addAll(Arrays.asList(2, 3, 4));

// Check
        set.contains(1);   // true
        set.contains(99);  // false

// Remove
        set.remove(1);          // true (removed)
        set.remove(99);         // false (not present)
        set.removeAll(Arrays.asList(2, 3));  // remove multiple

// Iterate (order is not guaranteed)
        for (int val : set) {
            System.out.println(val);
        }
        set.forEach(System.out::println);

// Set operations
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);           // {1, 2, 3, 4, 5, 6}

// Intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b); // {3, 4}

// Difference (A - B)
        Set<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);         // {1, 2}

// Is subset?
        a.containsAll(b);  // false (b has 5, 6 not in a)

// Convert to sorted list
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

// Convert to array
        Integer[] arr = set.toArray(new Integer[0]);

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        System.out.println(set);
    }
}