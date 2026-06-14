package HashMapAndTreeMap;
/*
====================================================
COORDINATE COMPRESSION
====================================================

Problem:

Values are huge.

Example:

[1000, 50000, 999999, 1000]

Suppose we want:

Array Index
Segment Tree
Fenwick Tree

Huge values waste memory.

====================================================
IDEA
====================================================

Replace large values
with small ranks.

Example:

Original:

[1000, 50000, 999999, 1000]

Sorted Unique:

[1000, 50000, 999999]

Assign Rank:

1000   -> 0
50000  -> 1
999999 -> 2

Compressed:

[0,1,2,0]

====================================================
WHY DO THIS?
====================================================

Original Range:

1000 -> 999999

Need huge memory.

After Compression:

0 -> 2

Very small range.

====================================================
TREEMAP ROLE
====================================================

TreeMap automatically keeps
keys sorted.

Example:

TreeMap

{
1000,
50000,
999999
}

Traverse in sorted order
and assign ranks.

====================================================
VISUALIZATION
====================================================

Input:

[50,10,30,50,20]

----------------------------------------------------

Step 1

Store unique values.

TreeMap:

{
10,
20,
30,
50
}

----------------------------------------------------

Step 2

Assign ranks.

10 -> 0
20 -> 1
30 -> 2
50 -> 3

----------------------------------------------------

Step 3

Replace values.

50 -> 3
10 -> 0
30 -> 2
50 -> 3
20 -> 1

Compressed:

[3,0,2,3,1]

====================================================
INTERVIEW USES
====================================================

Segment Tree
Fenwick Tree (BIT)
Range Queries
Inversion Count
Line Sweep
Geometry Problems

====================================================
CHEAT CODE
====================================================

Large Values
     ↓

Sorted Unique Values
     ↓

Assign Rank
     ↓

Replace Original Values

====================================================
*/


import java.util.*;

public class CordinateCompression {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : arr) {
            set.add(num);
        }

        TreeMap<Integer, Integer> compress = new TreeMap<>();

        int rank = 0;

        for (int val : set) {
            compress.put(val, rank++);
        }

        System.out.println("Compressed Array:");

        for (int num : arr) {
            System.out.print(compress.get(num) + " ");
        }
    }
}


/*

TreeMap Lookup

get()

O(log N)

----------------------------------

HashMap Lookup

get()

O(1)

----------------------------------

After sorting once,
all future lookups become O(1)

====================================================

 */


/*
Coordinate Compression

1. Copy Array
2. Sort Copy
3. Assign Rank Using HashMap
4. Replace Values

Complexity:

Sorting:
O(N log N)

Compression:
O(N)

Total:
O(N log N)

====================================================
*/