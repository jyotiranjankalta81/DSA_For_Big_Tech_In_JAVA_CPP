package ComparatorComparableAndCollections;

import java.util.*;
public class CoreConcept {

    public static  void main (String []  args){


        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));

// Sorting
        Collections.sort(list);                         // ascending — [1,1,2,3,4,5,6,9]
        Collections.sort(list, Collections.reverseOrder()); // descending — [9,6,5,4,3,2,1,1]

// Searching (binary search — list must be sorted)
        int idx = Collections.binarySearch(list, 5);    // index of 5 (or negative)
// If not found: returns -(insertion point) - 1

// Min/Max
        Collections.min(list);   // 1
        Collections.max(list);   // 9
        Collections.min(list, Comparator.reverseOrder());  // with comparator

// Frequency
        Collections.frequency(list, 1);  // 2 (count of 1s)

// Reverse
        Collections.reverse(list);       // reverse in-place

// Shuffle
        Collections.shuffle(list);       // random order
        Collections.shuffle(list, new Random(42));  // with seed

// Fill
        Collections.fill(list, 0);       // fill all with 0

// Copy
        List<Integer> dest = new ArrayList<>(Collections.nCopies(list.size(), 0));
        Collections.copy(dest, list);    // copy list into dest (dest must be same size)

// Swap
        Collections.swap(list, 0, list.size() - 1);  // swap first and last

// Rotate
        Collections.rotate(list, 2);    // rotate right by 2

// Disjoint
//        Collections.disjoint(list1, list2);  // true if no common elements

// Unmodifiable wrappers
        List<Integer> unmod = Collections.unmodifiableList(list);
//        Set<Integer> unmodSet = Collections.unmodifiableSet(set);
//        Map<K, V> unmodMap = Collections.unmodifiableMap(map);

// Synchronized wrappers (thread-safe, but usually use ConcurrentHashMap instead)
        List<Integer> syncList = Collections.synchronizedList(list);

// Empty and singleton
        List<Integer> empty = Collections.emptyList();   // immutable empty list
        List<Integer> single = Collections.singletonList(42); // immutable single-element

// nCopies
        List<Integer> zeros = Collections.nCopies(5, 0);  // [0, 0, 0, 0, 0]


    }
}
