package TwoPointers;
/*
====================================================
CONCEPT
====================================================

Converging Pointers means

One pointer starts from LEFT

One pointer starts from RIGHT

Both move towards each other.

----------------------------------------------------

left ---> <--- right

====================================================
WHEN TO USE?
====================================================

Sorted Array

Palindrome

Pair Sum

Container With Most Water

Trapping Rain Water

====================================================
WHY USE IT?
====================================================

Instead of checking every pair

O(N²)

we intelligently eliminate
impossible answers.

Often becomes:

O(N)

====================================================
VISUALIZATION
====================================================

Array:

[1,2,3,4,6,8]

Target = 10

left = 1

right = 8

----------------------------------------------------

1 + 8 = 9

Too Small

Move Left

----------------------------------------------------

2 + 8 = 10

Found

====================================================
CHEAT CODE
====================================================

Question contains:

Sorted Array

Pair Sum

Palindrome

Think:

Converging Pointers

====================================================
TIME & SPACE
====================================================

Time : O(N)

Space : O(1)

====================================================
*/

/*
====================================================
INPUT
====================================================

[1,2,3,4,6,8]

Target = 10

====================================================
STEP 1
====================================================

left = 0

right = 5

Values:

1 and 8

Sum = 9

----------------------------------------------------

Too Small

Need Bigger Sum

Move Left++

====================================================
STEP 2
====================================================

left = 1

right = 5

Values:

2 and 8

Sum = 10

Found Answer

====================================================
WHY MOVE LEFT?
====================================================

Array is sorted.

Current:

1 + 8 = 9

Need larger value.

Moving right pointer left

would make sum even smaller.

Only option:

Move left pointer right.

====================================================
*/

import java.util.*;

public class ConvergingPointers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int left = 0;
        int right = n - 1;

        boolean found = false;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {

                System.out.println(
                        "Pair Found: "
                                + arr[left]
                                + " "
                                + arr[right]
                );

                found = true;
                break;
            }

            else if (sum < target) {

                left++;
            }

            else {

                right--;
            }
        }

        if (!found) {
            System.out.println("No Pair Found");
        }
    }
}


//Question says:
//
//        ✔ Sorted Array
//
//✔ Pair Sum
//
//✔ Two Sum Sorted
//
//✔ Palindrome
//
//✔ Reverse String
//
//✔ Container With Most Water
//
//Think:
//
//CONVERGING POINTERS
//
//left = 0
//
//right = n-1
//
//Move Towards Each Other



//1. Converging Pointers
//   -> Two Sum Sorted
//   -> Palindrome
//
//2. Same Direction Pointers
//   -> Remove Duplicates
//   -> Move Zeroes
//
//3. Sliding Window
//   -> Longest Substring
//
//4. Fast & Slow Pointers
//   -> Linked List Cycle
//
//5. Partition Pointers
//   -> Quick Sort
//   -> Dutch National Flag


//Array Sorted?
//
//Need Pair?
//
//Need Compare Ends?
//
//Think:
//
//LEFT -------- RIGHT
//
//Move Towards Center
//
//= Converging Pointers













