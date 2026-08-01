package BinarySearch;

/*
Question says:

✔ Infinite Sorted Array

✔ Unknown Size

✔ Search Element

✔ Cannot Use Length

Think:

Expand Window

Then Binary Search

--------------------------------

1

2

4

8

16

32

64

...
 */


/*
/*
====================================================
COMMON INTERVIEW VERSION
====================================================

left = right + 1;

right = right +
        (right - left + 1) * 2;

====================================================
SIMPLER VERSION
====================================================

right = right * 2

Often accepted.

====================================================
WHY DOUBLING?
====================================================

1
2
4
8
16
32
64
128

----------------------------------------------------

Very quickly reaches
target range.

====================================================
TIME
====================================================

Window Expansion

O(log position)

----------------------------------------------------

Binary Search

O(log position)

----------------------------------------------------

Total

O(log position)

====================================================
*/


import java.util.*;

public class InfiniteArraySearch {

    public static int infiniteSearch(
            int[] arr,
            int target) {

        int left = 0;
        int right = 1;

        // Expand search window
        while (right < arr.length
                && arr[right] < target) {

            left = right + 1;

            right = right * 2;
        }

        // Safety for finite array simulation
        right =
                Math.min(
                        right,
                        arr.length - 1
                );

        // Normal Binary Search
        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println(
                "Enter sorted elements:"
        );

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(
                "Enter target: "
        );

        int target = sc.nextInt();

        int index =
                infiniteSearch(
                        arr,
                        target
                );

        System.out.println(
                "Index = " + index
        );
    }
}
