package PriorityQueue;
/*
====================================================
CONCEPT
====================================================

Problem:

List 1: 1 -> 4 -> 5

List 2: 1 -> 3 -> 4

List 3: 2 -> 6

Merge into:

1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

====================================================
BRUTE FORCE
====================================================

Put all elements into one array

Sort again

Time:

O(N log N)

N = total nodes

====================================================
OPTIMAL IDEA
====================================================

Use Min Heap

Heap always keeps
the smallest available node
from each list.

----------------------------------------------------

Initially:

List1 -> 1
List2 -> 1
List3 -> 2

Heap:

[1,1,2]

----------------------------------------------------

Remove smallest

1

Add next node from same list

Heap:

[1,2,4]

----------------------------------------------------

Again remove smallest

1

Add next node from same list

Heap:

[2,3,4]

Continue until heap empty.

====================================================
WHY DOES THIS WORK?
====================================================

Each list is already sorted.

Need only the smallest among
current heads of all lists.

Min Heap gives that instantly.

====================================================
DRY RUN
====================================================

Lists:

1->4->5

1->3->4

2->6

----------------------------------------------------

Heap:

[1,1,2]

Take 1

Add 4

Heap:

[1,2,4]

----------------------------------------------------

Take 1

Add 3

Heap:

[2,3,4]

----------------------------------------------------

Take 2

Add 6

Heap:

[3,4,6]

Continue...

Result:

1->1->2->3->4->4->5->6

====================================================
CHEAT CODE
====================================================

Question says:

Merge K Sorted Lists

Merge K Sorted Arrays

Smallest among K sources

Think:

MIN HEAP

====================================================
TIME & SPACE
====================================================

N = Total Nodes

K = Number of Lists

Time:

O(N log K)

Space:

O(K)

====================================================
*/

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lists (K): ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {

            System.out.print("Enter size of list " + (i + 1) + ": ");
            int size = sc.nextInt();

            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            System.out.println("Enter elements:");

            for (int j = 0; j < size; j++) {

                int val = sc.nextInt();

                current.next = new ListNode(val);
                current = current.next;
            }

            lists[i] = dummy.next;
        }

        ListNode result = mergeKLists(lists);

        System.out.println("Merged List:");

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        // Min Heap based on node value
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(
                        (a, b) -> a.val - b.val
                );

        // Add first node of every list
        for (ListNode node : lists) {

            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Smallest node
            ListNode smallest = pq.poll();

            tail.next = smallest;
            tail = tail.next;

            // Add next node from same list
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}