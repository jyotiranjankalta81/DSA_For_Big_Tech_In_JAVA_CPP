package HashSet;
/*
====================================================
LONGEST CONSECUTIVE SEQUENCE
====================================================

Question:

Array:

[100,4,200,1,3,2]

Need:

Longest consecutive sequence.

Consecutive means:

1,2,3,4

Length = 4

Answer = 4

====================================================
BRUTE FORCE
====================================================

For every number:

Check next number
Check next number
Check next number

Very slow.

O(N²)

====================================================
HASHSET IDEA
====================================================

Store all numbers in HashSet.

Why?

contains()

O(1)

====================================================
STEP 1
====================================================

Array:

[100,4,200,1,3,2]

HashSet:

{
100,
4,
200,
1,
3,
2
}

====================================================
STEP 2
FIND STARTING POINT
====================================================

For each number:

Check:

num - 1 exists?

----------------------------------------------------

num = 100

99 exists?

NO

100 can start sequence.

----------------------------------------------------

num = 4

3 exists?

YES

Not a starting point.

----------------------------------------------------

num = 3

2 exists?

YES

Not a starting point.

----------------------------------------------------

num = 2

1 exists?

YES

Not a starting point.

----------------------------------------------------

num = 1

0 exists?

NO

1 can start sequence.

====================================================
WHY CHECK num-1 ?
====================================================

Without this:

1 starts sequence
2 starts sequence
3 starts sequence
4 starts sequence

Repeated work.

====================================================
START FROM 1
====================================================

Current = 1

Check:

2 exists? YES
3 exists? YES
4 exists? YES
5 exists? NO

Sequence:

1,2,3,4

Length = 4

====================================================
START FROM 100
====================================================

101 exists?

NO

Length = 1

====================================================
MAXIMUM
====================================================

max(4,1,1)

Answer = 4

====================================================
INTERVIEW CHEAT CODE
====================================================

If num-1 does NOT exist

Then num is beginning
of a sequence.

Expand forward.

====================================================
TIME COMPLEXITY
====================================================

Each element visited
at most once.

O(N)

====================================================
*/

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start of sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        System.out.println("Longest Length = " + longest);
    }
}