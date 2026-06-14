package HashMapAndTreeMap;

/*
====================================================
SLIDING WINDOW MAXIMUM
====================================================

Question:

Array = [1,3,-1,-3,5,3,6,7]

Window Size = 3

Window moves one step at a time.

----------------------------------------------------

Window 1

[1,3,-1]

Maximum = 3

----------------------------------------------------

Window 2

[3,-1,-3]

Maximum = 3

----------------------------------------------------

Window 3

[-1,-3,5]

Maximum = 5

----------------------------------------------------

Window 4

[-3,5,3]

Maximum = 5

----------------------------------------------------

Window 5

[5,3,6]

Maximum = 6

----------------------------------------------------

Window 6

[3,6,7]

Maximum = 7

Output:

[3,3,5,5,6,7]

====================================================
NAIVE APPROACH
====================================================

For every window:

Find maximum by scanning.

Example:

Window Size = K

Scan K elements every time.

Time Complexity:

O(N*K)

Bad for large inputs.

====================================================
TREEMAP IDEA
====================================================

Keep current window elements
inside a TreeMap.

TreeMap stores:

Number -> Frequency

Example:

Window:

[1,3,-1]

TreeMap:

{
 -1=1,
  1=1,
  3=1
}

Since TreeMap is sorted:

lastKey()

gives maximum.

lastKey() = 3

====================================================
WINDOW MOVEMENT
====================================================

Current Window:

[1,3,-1]

Move window right.

Outgoing element:

1

Incoming element:

-3

Remove 1 frequency.

Add -3 frequency.

New TreeMap:

{
 -3=1,
 -1=1,
  3=1
}

Maximum:

lastKey() = 3

====================================================
WHY FREQUENCY?
====================================================

Window:

[5,5,3]

TreeMap:

{
 3=1,
 5=2
}

One 5 leaves.

{
 3=1,
 5=1
}

Still another 5 exists.

Need frequency count.

====================================================
INTERVIEW CHEAT CODE
====================================================

TreeMap<Integer,Integer>

key   = number
value = frequency

Insert incoming element

Remove outgoing element

Maximum:

map.lastKey()

Time:

Insert = O(log K)
Remove = O(log K)
Get Max = O(log K)

Total:

O(N log K)

====================================================
MONOTONIC DEQUE
====================================================

Best solution:

O(N)

But TreeMap solution is easier
to understand initially.

====================================================
*/


import java.util.*;

public class WindowMaximumTreeMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        List<Integer> result = new ArrayList<>();

        // Build first window
        for (int i = 0; i < k; i++) {
            map.put(nums[i],
                    map.getOrDefault(nums[i], 0) + 1);
        }

        result.add(map.lastKey());

        // Slide window
        for (int i = k; i < n; i++) {

            int outgoing = nums[i - k];
            int incoming = nums[i];

            // Remove outgoing element
            map.put(outgoing,
                    map.get(outgoing) - 1);

            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }

            // Add incoming element
            map.put(incoming,
                    map.getOrDefault(incoming, 0) + 1);

            result.add(map.lastKey());
        }

        System.out.println(result);
    }
}


/*
    Sliding Window Maximum

Level 1:
Brute Force
O(N*K)

Level 2:
TreeMap
O(N log K)

Level 3:
Monotonic Deque
O(N)  <-- Optimal
 */