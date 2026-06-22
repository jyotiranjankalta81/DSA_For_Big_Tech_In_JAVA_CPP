package SlidingWindow;
/*
====================================================
CONCEPT
====================================================

Unlike Fixed Window,

Window size is NOT fixed.

It expands and shrinks
based on a condition.

====================================================
COMMON QUESTIONS
====================================================

Longest Substring Without Repeating

Smallest Subarray Sum >= K

Longest Subarray Sum <= K

Max Consecutive Ones

Fruit Into Baskets

====================================================
IDEA
====================================================

Use Two Pointers

left
right

----------------------------------------------------

Expand Window

Move right

----------------------------------------------------

Condition Violated?

Shrink Window

Move left

====================================================
VISUALIZATION
====================================================

Array:

[2,1,5,2,3,2]

Target = 7

----------------------------------------------------

right →

[2]

Sum = 2

----------------------------------------------------

[2,1]

Sum = 3

----------------------------------------------------

[2,1,5]

Sum = 8

Condition met

Try shrinking

====================================================
CHEAT CODE
====================================================

Fixed Window

Window Size Known

----------------------------------------------------

Variable Window

Condition Given

Think:

Expand + Shrink

====================================================
TIME & SPACE
====================================================

Time : O(N)

Space : O(1)

Each element enters
and leaves window once.

====================================================
*/

import java.util.Arrays;
import java.util.Scanner;

/*
====================================================
INPUT
====================================================

Array:

[2,1,5,2,3,2]

Target = 7

====================================================
START
====================================================

left = 0

sum = 0

minLength = INF

====================================================
right = 0
====================================================

Add 2

Window:

[2]

Sum = 2

====================================================
right = 1
====================================================

Add 1

Window:

[2,1]

Sum = 3

====================================================
right = 2
====================================================

Add 5

Window:

[2,1,5]

Sum = 8

Condition met

Length = 3

minLength = 3

----------------------------------------------------

Shrink

Remove 2

Window:

[1,5]

Sum = 6

Stop shrinking

====================================================
right = 3
====================================================

Add 2

Window:

[1,5,2]

Sum = 8

Length = 3

----------------------------------------------------

Shrink

Remove 1

Window:

[5,2]

Sum = 7

Length = 2

minLength = 2

----------------------------------------------------

Shrink Again

Remove 5

Window:

[2]

Sum = 2

Stop

====================================================
ANSWER
====================================================

Smallest Length = 2

Subarray:

[5,2]

====================================================
*/
import java.util.*;
public class VariableSizeWindow {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array Size");
        int n = sc.nextInt();
        System.out.println("Enter the list of elements");
        int[] arr = new int [n];

        for(int i=0; i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("Enter the target value");
        int target = sc.nextInt();
        int left=0;
        int minLength=Integer.MAX_VALUE;
        int sum =0;
        for (int right=0;right<n;right++){
            sum += arr[right];
            while (sum>=target){
                minLength =
                        Math.min(
                                minLength,
                                right - left + 1
                        );
                sum -= arr[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No valid subarray");
        } else {
            System.out.println(
                    "Smallest Length = "
                            + minLength
            );
        }
    }
}
