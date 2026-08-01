package BinarySearch;
/*
====================================================
PROBLEM
====================================================

Given a sorted array
rotated at some pivot.

Find target element.

----------------------------------------------------

Example:

Original:

[1,2,3,4,5,6,7]

Rotated:

[4,5,6,7,1,2,3]

Target = 2

Answer = Index 5

====================================================
WHY NORMAL BINARY SEARCH
DOESN'T WORK?
====================================================

Binary Search assumes:

Entire array sorted.

----------------------------------------------------

Rotated Array:

[4,5,6,7,1,2,3]

Not fully sorted.

====================================================
KEY OBSERVATION
====================================================

At least ONE HALF

is always sorted.

----------------------------------------------------

Example:

[4,5,6,7,1,2,3]

mid = 7

Left Half:

[4,5,6,7]

Sorted

----------------------------------------------------

Right Half:

[1,2,3]

Sorted

====================================================
IDEA
====================================================

Find mid.

Check which half
is sorted.

----------------------------------------------------

If target lies inside
sorted half

Search there.

----------------------------------------------------

Else

Search other half.

====================================================
CHEAT CODE
====================================================

Question says:

Rotated Sorted Array

Search Element

O(log N)

Think:

Modified Binary Search

====================================================
TIME & SPACE
====================================================

Time  : O(log N)

Space : O(1)

====================================================
*/
public class SearchRotatedArray {

    public static int searchRotatedArr(
            int[] arr,
            int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left half sorted
            if (arr[left] <= arr[mid]) {

                if (target >= arr[left]
                        && target < arr[mid]) {

                    right = mid - 1;

                } else {

                    left = mid + 1;
                }
            }

            // Right half sorted
            else {

                if (target > arr[mid]
                        && target <= arr[right]) {

                    left = mid + 1;

                } else {

                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
