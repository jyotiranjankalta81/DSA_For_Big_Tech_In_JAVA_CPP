package TwoPointers;
/*
====================================================
CONCEPT
====================================================

Two pointers move at
different speeds.

----------------------------------------------------

Slow Pointer

Moves 1 step

----------------------------------------------------

Fast Pointer

Moves 2 steps

====================================================
WHY USE IT?
====================================================

Need to detect:

✔ Linked List Cycle

✔ Middle of Linked List

✔ Happy Number

✔ Find Duplicate Number

✔ Cycle in Array

====================================================
VISUALIZATION
====================================================

1 -> 2 -> 3 -> 4
          ^     |
          |_____|

Cycle exists

----------------------------------------------------

Slow:

1 step

Fast:

2 steps

Eventually

Fast catches Slow

inside the cycle.

====================================================
CHEAT CODE
====================================================

Cycle Detection

Middle Node

Think:

Fast & Slow Pointers

====================================================
TIME & SPACE
====================================================

Time : O(N)

Space: O(1)

====================================================
*/

/*
====================================================
LINKED LIST
====================================================

1 -> 2 -> 3 -> 4 -> 5
          ^         |
          |_________|

====================================================
START
====================================================

Slow = 1

Fast = 1

====================================================
STEP 1
====================================================

Slow -> 2

Fast -> 3

====================================================
STEP 2
====================================================

Slow -> 3

Fast -> 5

====================================================
STEP 3
====================================================

Slow -> 4

Fast -> 4

----------------------------------------------------

Slow == Fast

Cycle Found

====================================================
WHY?
====================================================

Inside a cycle

Fast keeps gaining
1 node per move.

Eventually catches Slow.

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

public class FastandSlowPointers {

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null &&
                fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        /*
         Demo Linked List:

         1 -> 2 -> 3 -> 4 -> 5
                   ^         |
                   |_________|
        */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =
                new ListNode(5);

        // Create cycle
        head.next.next.next.next.next =
                head.next.next;

        System.out.println(
                hasCycle(head)
        );
    }
}
