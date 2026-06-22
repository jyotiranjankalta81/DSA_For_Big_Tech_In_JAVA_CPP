package Sorting;
/*
====================================================
INPUT
====================================================

[8,4,7,3,10,5]

Pivot = Last Element = 5

====================================================
PARTITION PROCESS
====================================================

Array:

[8,4,7,3,10,5]

          Pivot

----------------------------------------------------

Keep pointer i

i = -1

====================================================
j = 0

8 < 5 ?

NO

Do nothing

====================================================
j = 1

4 < 5 ?

YES

i++

i = 0

Swap arr[i], arr[j]

Swap:

8 and 4

Array:

[4,8,7,3,10,5]

====================================================
j = 2

7 < 5 ?

NO

====================================================
j = 3

3 < 5 ?

YES

i++

i = 1

Swap:

8 and 3

Array:

[4,3,7,8,10,5]

====================================================
j = 4

10 < 5 ?

NO

====================================================
END OF LOOP
====================================================

i = 1

Place pivot at correct position

Swap:

arr[i+1] and pivot

Swap:

7 and 5

Array:

[4,3,5,8,10,7]

      ^

Pivot Index = 2

====================================================
IMPORTANT
====================================================

Everything left of pivot

< 5

Everything right of pivot

> 5

Pivot is now fixed forever.

====================================================
NEXT RECURSION
====================================================

Left:

[4,3]

Right:

[8,10,7]

Sort both recursively.

====================================================
FINAL RESULT
====================================================

[3,4,5,7,8,10]

====================================================
*/

import java.util.Scanner;

public class QuickSort {


    // Average O(n log n), O(n²) worst (mitigated by random pivot)
   public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIdx = partition(arr, left, right);
        quickSort(arr, left, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        // Randomize pivot to avoid O(n²) worst case
        int randIdx = left + (int)(Math.random() * (right - left + 1));
        swap(arr, randIdx, right);

        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static  void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
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

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
