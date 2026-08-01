package BinarySearch;
/*
====================================================
PROBLEM
====================================================

Array:

[1,2,2,2,3,4,5]

Target = 2

----------------------------------------------------

First Position = 1

Last Position = 3

====================================================
WHY NORMAL BINARY SEARCH
IS NOT ENOUGH?
====================================================

Normal Binary Search

returns ANY occurrence.

Could return:

1

or

2

or

3

----------------------------------------------------

But interview asks:

FIRST occurrence

or

LAST occurrence

====================================================
KEY IDEA
====================================================

When target found:

DON'T STOP

Continue searching.

----------------------------------------------------

FIRST OCCURRENCE

Move LEFT

right = mid - 1

----------------------------------------------------

LAST OCCURRENCE

Move RIGHT

left = mid + 1

====================================================
CHEAT CODE
====================================================

Question says:

First Position

Last Position

Lower Bound

Upper Bound

Think:

Modified Binary Search

====================================================
TIME & SPACE
====================================================

Time : O(log N)

Space: O(1)

====================================================
*/
public class FindBoundary {
    /*
====================================================
INPUT
====================================================

[1,2,2,2,3,4]

Target = 2

====================================================
STEP 1
====================================================

left = 0

right = 5

mid = 2

arr[mid] = 2

----------------------------------------------------

Target Found

Store Answer = 2

But continue LEFT

right = mid - 1

right = 1

====================================================
STEP 2
====================================================

left = 0

right = 1

mid = 0

arr[mid] = 1

----------------------------------------------------

Target Bigger

left = 1

====================================================
STEP 3
====================================================

left = 1

right = 1

mid = 1

arr[mid] = 2

----------------------------------------------------

Found Again

Store Answer = 1

Move LEFT Again

right = 0

====================================================
END
====================================================

Answer = 1

====================================================
*/

    /*
====================================================
FIRST OCCURRENCE
====================================================

Found Target

Store Answer

Search LEFT

right = mid - 1

====================================================
LAST OCCURRENCE
====================================================

Found Target

Store Answer

Search RIGHT

left = mid + 1

====================================================
*/
    // Find First Occurrence
    public static int firstPosition(
            int[] arr,
            int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            if (arr[mid] == target) {

                answer = mid;

                // Search Left Side
                right = mid - 1;
            }

            else if (arr[mid] < target) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return answer;
    }

    // Find Last Occurrence
    public static int lastPosition(
            int[] arr,
            int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            if (arr[mid] == target) {

                answer = mid;

                // Search Right Side
                left = mid + 1;
            }

            else if (arr[mid] < target) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return answer;
    }
}
