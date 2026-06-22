package Sorting;
/*
====================================================
CONCEPT
====================================================

Insertion Sort works like
sorting playing cards in hand.

----------------------------------------------------

Example:

Cards:

8 4 2 6

Take one card at a time

and insert it into the
correct position.

====================================================
IDEA
====================================================

Assume first element
is already sorted.

For each new element:

Move larger elements
one position right.

Insert current element
at correct position.

====================================================
VISUALIZATION
====================================================

Array:

[8,4,2,6]

----------------------------------------------------

Sorted Part | Unsorted Part

[8]         [4,2,6]

Take 4

Move 8 right

[4,8]       [2,6]

----------------------------------------------------

Take 2

Move 8 right
Move 4 right

[2,4,8]     [6]

----------------------------------------------------

Take 6

Move 8 right

Insert 6

[2,4,6,8]

====================================================
WHY DOES IT WORK?
====================================================

After every iteration

Left side remains sorted.

Current element is inserted
at its correct position.

====================================================
CHEAT CODE
====================================================

Pick Element

Shift Larger Elements Right

Insert at Correct Position

====================================================
TIME & SPACE
====================================================

Best Case:

O(N)

(nearly sorted array)

----------------------------------------------------

Average:

O(N²)

----------------------------------------------------

Worst:

O(N²)

----------------------------------------------------

Space:

O(1)

(In-place)

====================================================
*/

import java.util.*;

public class InsertationSort {

    public static void insertionSort(int[] arr) {

        // Start from 2nd element
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            // Shift larger elements right
            while (j >= 0 && arr[j] > current) {

                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current element
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}