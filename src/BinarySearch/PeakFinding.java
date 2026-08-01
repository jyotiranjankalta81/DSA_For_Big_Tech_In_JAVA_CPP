package BinarySearch;

public class PeakFinding {


    /*
====================================================
IMPORTANT
====================================================

Suppose:

[1,5,3]

mid = 1

Value = 5

----------------------------------------------------

5 > 3

Peak might be mid itself.

If we do:

right = mid - 1

We lose peak 5.

----------------------------------------------------

Correct:

right = mid

Keep peak candidate.

====================================================
*/
    public static int findPeak(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
/*
1. Classic Binary Search
   -> Search Element

2. First/Last Occurrence
   -> Lower Bound

3. Search Insert Position

4. Rotated Sorted Array

5. Peak Finding
   -> Binary Search on Slope

6. Find Minimum in Rotated Array

7. Binary Search on Answer

8. Aggressive Cows

9. Allocate Books

Peak Problem

Don't compare with target.

Compare with neighbor.

--------------------------------

arr[mid] < arr[mid+1]

→ Climbing Hill
→ Go Right

--------------------------------

arr[mid] > arr[mid+1]

→ Going Downhill
→ Go Left

Eventually reach Peak.
 */