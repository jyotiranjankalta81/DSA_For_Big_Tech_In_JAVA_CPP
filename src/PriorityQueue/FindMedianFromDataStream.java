package PriorityQueue;
/*
====================================================
CONCEPT
====================================================

Problem:

Numbers come one by one.

Example:

5
15
1
3

After every insertion,
find median quickly.

----------------------------------------------------

Median

Sorted:

[1,3,5]

Median = 3

----------------------------------------------------

Sorted:

[1,3,5,15]

Median = (3+5)/2 = 4

====================================================
IDEA
====================================================

Use TWO HEAPS

1. Max Heap (left half)

Stores smaller numbers

Top = largest among smaller numbers

----------------------------------------------------

2. Min Heap (right half)

Stores larger numbers

Top = smallest among larger numbers

====================================================
VISUALIZATION
====================================================

Numbers:

1 3 5 15

Max Heap          Min Heap

[3,1]             [5,15]

----------------------------------------------------

Left Half

1 3

----------------------------------------------------

Right Half

5 15

====================================================
MEDIAN RULE
====================================================

If sizes equal:

Median =

(maxHeap.top + minHeap.top)/2

----------------------------------------------------

If one heap has extra element:

Median = top of bigger heap

====================================================
BALANCING RULE
====================================================

Difference between heap sizes
should never exceed 1.

====================================================
CHEAT CODE
====================================================

Median Data Stream

Think:

Two Heaps

Max Heap -> Left Half

Min Heap -> Right Half

====================================================
TIME & SPACE
====================================================

Insert : O(log N)

Find Median : O(1)

Space : O(N)

====================================================
*/


import java.util.*;

public class FindMedianFromDataStream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Max Heap for smaller half
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap for larger half
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();

            // Step 1: Insert
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Step 2: Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {

                minHeap.offer(maxHeap.poll());

            } else if (minHeap.size() > maxHeap.size() + 1) {

                maxHeap.offer(minHeap.poll());
            }

            // Step 3: Find median
            double median;

            if (maxHeap.size() == minHeap.size()) {

                median =
                        (maxHeap.peek() + minHeap.peek()) / 2.0;

            } else if (maxHeap.size() > minHeap.size()) {

                median = maxHeap.peek();

            } else {

                median = minHeap.peek();
            }

            System.out.println(
                    "Median after inserting "
                            + num + " = " + median
            );
        }
    }
}

/*
====================================================
INSERT 5
====================================================

Max Heap:

[5]

Min Heap:

[]

Median = 5

====================================================
INSERT 15
====================================================

15 > 5

Put in Min Heap

Max Heap:

[5]

Min Heap:

[15]

Sizes Equal

Median:

(5 + 15)/2

= 10

====================================================
INSERT 1
====================================================

1 < 5

Put in Max Heap

Max Heap:

[5,1]

Min Heap:

[15]

Median:

Top of bigger heap

= 5

====================================================
INSERT 3
====================================================

3 < 5

Put in Max Heap

Max Heap:

[5,1,3]

Min Heap:

[15]

----------------------------------------------------

Unbalanced

Size Difference = 2

Move largest from Max Heap
to Min Heap

Move 5

----------------------------------------------------

Max Heap:

[3,1]

Min Heap:

[5,15]

Median:

(3 + 5)/2

= 4

====================================================
*/