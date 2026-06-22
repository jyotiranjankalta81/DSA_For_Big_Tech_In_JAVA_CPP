package Deque;
/*
====================================================
CONCEPT
====================================================

Problem:

Array = [1,3,-1,-3,5,3,6,7]

K = 3

Windows:

[1,3,-1]  -> 3
[3,-1,-3] -> 3
[-1,-3,5] -> 5

Need maximum of every window.

----------------------------------------------------

IDEA

Use a Deque that stores INDICES.

Maintain it in DECREASING order.

Example:

Values in deque:

[8,5,3]

Front always contains maximum.

----------------------------------------------------

When new element arrives:

Remove all smaller elements
from the BACK.

Why?

Because they can never become
maximum in future.

====================================================
DRY RUN
====================================================

Array:

[1,3,-1]

Add 1

Deque:

[1]

--------------------

Add 3

1 < 3

Remove 1

Deque:

[3]

--------------------

Add -1

Deque:

[3,-1]

Maximum:

Front = 3

====================================================
CHEAT CODE
====================================================

Sliding Window Maximum

Front = Maximum

Back = Remove Smaller Elements

Store INDICES not values

====================================================
TIME & SPACE
====================================================

Time  : O(N)

Space : O(K)

====================================================
*/

import java.util.*;

public class MonotonicDeque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter window size K: ");
        int k = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() &&
                    nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Window formed
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }

        System.out.println("Sliding Window Maximum:");
        System.out.println(result);
    }
}