package PriorityQueue;
/*
====================================================
CONCEPT
====================================================

Problem:

Array:

[3,2,1,5,6,4]

K = 2

Sorted:

[1,2,3,4,5,6]

2nd Largest = 5

----------------------------------------------------

IDEA

Use a Min Heap of size K.

Why?

Keep only the K largest elements
seen so far.

The smallest among those K
elements will be the answer.

====================================================
DRY RUN
====================================================

Array:

[3,2,1,5,6,4]

K = 2

Heap:

Add 3

[3]

--------------------

Add 2

[2,3]

--------------------

Add 1

[1,3,2]

Size > K

Remove 1

[2,3]

--------------------

Add 5

[2,3,5]

Remove 2

[3,5]

--------------------

Add 6

[3,5,6]

Remove 3

[5,6]

--------------------

Add 4

[4,6,5]

Remove 4

[5,6]

Answer:

Top = 5

====================================================
CHEAT CODE
====================================================

Kth Largest

Think:

Min Heap

Keep heap size = K

Top element
=
Kth Largest

====================================================
TIME & SPACE
====================================================

Time  : O(N log K)

Space : O(K)

====================================================
*/

import java.util.*;

public class KthLargestElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            // Keep only K elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(
                "Kth Largest Element = " + pq.peek()
        );
    }
}