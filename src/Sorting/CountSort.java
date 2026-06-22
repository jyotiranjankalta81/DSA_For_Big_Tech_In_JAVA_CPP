package Sorting;
/*
====================================================
CONCEPT
====================================================

Counting Sort is NOT a comparison sort.

Instead of comparing elements,
it counts how many times each
number appears.

----------------------------------------------------

Example:

Array:

[4,2,2,8,3,3,1]

Count Array:

Index : 0 1 2 3 4 5 6 7 8

Count : 0 1 2 2 1 0 0 0 1

----------------------------------------------------

Now rebuild array using counts.

Result:

[1,2,2,3,3,4,8]

====================================================
WHEN TO USE?
====================================================

Use when:

Range is small.

Example:

Marks: 0-100

Age: 0-120

Ratings: 1-5

----------------------------------------------------

Bad choice when:

Values are huge.

Example:

[1, 1000000000]

Need huge count array.

====================================================
IDEA
====================================================

Step 1:

Find maximum value.

----------------------------------------------------

Step 2:

Create count array

size = max + 1

----------------------------------------------------

Step 3:

Count frequency

count[num]++

----------------------------------------------------

Step 4:

Traverse count array

Put each number into
original array according
to its frequency.

====================================================
DRY RUN
====================================================

Input:

[4,2,2,8,3,3,1]

----------------------------------------------------

Count Frequencies

count[1] = 1
count[2] = 2
count[3] = 2
count[4] = 1
count[8] = 1

----------------------------------------------------

Build Result

1 -> once

[1]

2 -> twice

[1,2,2]

3 -> twice

[1,2,2,3,3]

4 -> once

[1,2,2,3,3,4]

8 -> once

[1,2,2,3,3,4,8]

====================================================
CHEAT CODE
====================================================

Small Range?

Think:

COUNTING SORT

Count Frequency

Rebuild Array

====================================================
TIME & SPACE
====================================================

N = Number of Elements

K = Maximum Value

Time:

O(N + K)

Space:

O(K)

====================================================
*/

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static  void countSort(int arr[], int maxVal){
        int[] count  =new int[maxVal+1] ;
        for (int n : arr) count[n]++;
        // Rebuild sorted array
        int index = 0;

        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {

                arr[index++] = i;

                count[i]--;
            }
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
        Arrays.sort(arr);
        int maxv= arr[arr.length-1];

        countSort(arr, maxv);

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/*
Question says:

- Values are small range
- Marks 0-100
- Ages 0-120
- Digits 0-9
- Frequency based sorting

Think:

COUNTING SORT

----------------------------------------------------

Merge Sort

O(N log N)

----------------------------------------------------

Counting Sort

O(N + K)

(K = Range)

Can be faster than O(N log N)
when K is small.
 */


/*
====================================================
WHY IS COUNTING SORT FAST?
====================================================

No comparisons.

No swapping.

Just counting frequencies.

----------------------------------------------------

Comparison Sorts:

Merge Sort
Quick Sort
Heap Sort

Need:

O(N log N)

----------------------------------------------------

Counting Sort:

O(N + K)

Can beat O(N log N)

if K is small.

====================================================
LIMITATION
====================================================

Range must be small.

Example:

[1, 1000000000]

Need count array of size
1 billion.

Not practical.

====================================================
*/