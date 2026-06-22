package TwoPointers;

/*
====================================================
PROBLEM
====================================================

Given array:

[-1,0,1,2,-1,-4]

Find all triplets whose sum = 0

----------------------------------------------------

Answer:

[-1,-1,2]

[-1,0,1]

====================================================
BRUTE FORCE
====================================================

Try every triplet

i
j
k

3 loops

Time:

O(N³)

Very Slow

====================================================
OPTIMAL IDEA
====================================================

1. Sort Array

2. Fix one element

3. Remaining problem becomes:

Two Sum

====================================================
WHY CALLED
THREE POINTERS?
====================================================

Pointer 1:

i (fixed element)

Pointer 2:

left

Pointer 3:

right

====================================================
VISUALIZATION
====================================================

Sorted:

[-4,-1,-1,0,1,2]

----------------------------------------------------

Fix:

i = -1

Need:

remaining sum = 1

----------------------------------------------------

left = next element

right = last element

Use Two Sum logic

====================================================
CHEAT CODE
====================================================

Question says:

Triplets

Three Numbers

3 Sum

Think:

Sort

Fix One

Two Pointers

====================================================
TIME & SPACE
====================================================

Sorting:

O(N log N)

----------------------------------------------------

Loop:

O(N)

Inside:

O(N)

----------------------------------------------------

Total:

O(N²)

Space:

O(1)

====================================================
*/

/*
====================================================
INPUT
====================================================

[-1,0,1,2,-1,-4]

====================================================
STEP 1
====================================================

Sort

[-4,-1,-1,0,1,2]

====================================================
STEP 2
====================================================

i = 0

Value = -4

Need:

4

----------------------------------------------------

left = 1

right = 5

----------------------------------------------------

-1 + 2 = 1

Too Small

Move Left

----------------------------------------------------

-1 + 2 = 1

Too Small

Move Left

----------------------------------------------------

0 + 2 = 2

Too Small

Move Left

----------------------------------------------------

1 + 2 = 3

Too Small

No Answer

====================================================
STEP 3
====================================================

i = 1

Value = -1

Need:

1

----------------------------------------------------

left = 2

right = 5

----------------------------------------------------

-1 + 2 = 1

MATCH

Triplet:

[-1,-1,2]

====================================================
MOVE BOTH
====================================================

left++

right--

----------------------------------------------------

left = 3

right = 4

----------------------------------------------------

0 + 1 = 1

MATCH

Triplet:

[-1,0,1]

====================================================
ANSWER
====================================================

[-1,-1,2]

[-1,0,1]

====================================================
*/



import java.util.*;

public class ThreePointers3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result =
                new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed values
            if (i > 0 &&
                    nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum =
                        nums[i]
                                + nums[left]
                                + nums[right];

                if (sum == 0) {

                    result.add(
                            Arrays.asList(
                                    nums[i],
                                    nums[left],
                                    nums[right]
                            )
                    );

                    left++;
                    right--;

                    // Skip duplicate left
                    while (left < right &&
                            nums[left]
                                    == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right
                    while (left < right &&
                            nums[right]
                                    == nums[right + 1]) {
                        right--;
                    }
                }

                else if (sum < 0) {

                    left++;
                }

                else {

                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans =
                threeSum(nums);

        System.out.println(ans);
    }
}


/*
Question says:

✔ Triplets

✔ 3 Numbers Sum

✔ Sum = Target

✔ Unique Triplets

Think:

Sort Array

Fix One Number

Apply Two Pointers

O(N²)
 */