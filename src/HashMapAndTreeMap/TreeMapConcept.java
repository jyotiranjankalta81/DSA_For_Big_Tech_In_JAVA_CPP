package HashMapAndTreeMap;
import  java.util.*;

/*
====================================================
TREE MAP
====================================================

TreeMap is a Map that stores keys
in SORTED ORDER automatically.

HashMap:

{50=Java, 10=Python, 30=C++}

Order NOT guaranteed.

TreeMap:

{10=Python, 30=C++, 50=Java}

Automatically sorted by key.

====================================================
INTERNAL DATA STRUCTURE
====================================================

HashMap
=
Hash Table

TreeMap
=
Red Black Tree
(Self Balancing Binary Search Tree)

====================================================
EXAMPLE
====================================================


TreeMap<Integer, String> map = new TreeMap<>();

map.put(50, "Java");
map.put(10, "Python");
map.put(30, "C++");

System.out.println(map);

/*
Output:

{10=Python, 30=C++, 50=Java}

====================================================
VISUALIZATION
====================================================

Insert 50

     50

Insert 10

     50
    /
   10

Insert 30

      30
     /  \
   10    50

TreeMap balances automatically.

====================================================
WHY USE TREEMAP ?
====================================================

Need sorted keys.

Example:

Student Marks

85 -> John
60 -> Alice
95 -> Bob

Want:

60
85
95

TreeMap does automatically.

====================================================
COMMON OPERATIONS
====================================================

put(key,value)
=
Insert

get(key)
=
Find value

remove(key)
=
Delete

====================================================
SPECIAL METHODS
====================================================


TreeMap<Integer,String> map = new TreeMap<>();

map.put(10,"A");
map.put(20,"B");
map.put(30,"C");
map.put(40,"D");

/*
====================================================
firstKey()
====================================================


map.firstKey(); // 10

/*
Smallest key

====================================================
lastKey()
====================================================


map.lastKey(); // 40

/*
Largest key

====================================================
higherKey()
====================================================


map.higherKey(20); // 30

/*
Next greater key

====================================================
lowerKey()
====================================================


map.lowerKey(20); // 10

/*
Next smaller key

====================================================
ceilingKey()
====================================================


map.ceilingKey(25); // 30

/*
Greater than or equal

====================================================
floorKey()
====================================================


map.floorKey(25); // 20

/*
Less than or equal

====================================================
COMPLEXITY
====================================================

HashMap

put()    O(1)
get()    O(1)
remove() O(1)

----------------------------------------------------

TreeMap

put()    O(log n)
get()    O(log n)
remove() O(log n)

Why?

Because TreeMap uses a balanced tree.

====================================================
INTERVIEW QUESTION
====================================================

HashMap vs TreeMap

HashMap
--------
Fastest
No ordering

TreeMap
--------
Sorted order
Slightly slower

====================================================
WHEN TO USE
====================================================

Need fastest lookup?

Use HashMap

Need sorted keys?

Use TreeMap

====================================================
INTERVIEW CHEAT CODE
====================================================

HashMap
=
Fast Search

TreeMap
=
Fast Search + Sorted Order

TreeMap internally uses
Red Black Tree

All operations:
O(log n)
====================================================
*/

public class TreeMapConcept {


    public static void main (String[] args){
        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(5, "five");
        tree.put(1, "one");
        tree.put(3, "three");
        tree.put(7, "seven");

// Sorted iteration
        for (Map.Entry<Integer, String> e : tree.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
// 1:one, 3:three, 5:five, 7:seven

// NavigableMap operations (unique to TreeMap)
        tree.firstKey();          // 1 (smallest)
        tree.lastKey();           // 7 (largest)
        tree.floorKey(4);         // 3 (largest key <= 4)
        tree.ceilingKey(4);       // 5 (smallest key >= 4)
        tree.lowerKey(5);         // 3 (strictly less than 5)
        tree.higherKey(5);        // 7 (strictly greater than 5)
        tree.pollFirstEntry();    // removes and returns entry with smallest key
        tree.pollLastEntry();     // removes and returns entry with largest key

// SubMap operations (range queries)
        tree.subMap(1, true, 5, true);   // keys in [1, 5] inclusive
        tree.headMap(5);                  // keys strictly less than 5
        tree.tailMap(3);                  // keys >= 3
        tree.descendingMap();             // reverse order view
        tree.descendingKeySet();          // reverse order keys

// Use case: find k-th smallest sum, sliding window maximum
// Use case: count smaller numbers — TreeMap + rank
    }
}
