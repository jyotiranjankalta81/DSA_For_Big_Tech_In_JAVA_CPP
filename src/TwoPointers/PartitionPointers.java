package TwoPointers;
/*
====================================================
CONCEPT
====================================================

Partition means:

Put elements satisfying
a condition on one side

and remaining elements
on the other side.

----------------------------------------------------

Example:

Array:

[8,4,7,3,10,5]

Pivot = 5

After Partition:

[4,3,5,8,10,7]

      ^

Pivot in correct position

====================================================
WHERE USED?
====================================================

✔ Quick Sort

✔ Quick Select

✔ Sort Colors

✔ Dutch National Flag

✔ Segregate Even/Odd

✔ Negative/Positive Separation

====================================================
IDEA
====================================================

Maintain boundary pointer.

Everything before boundary

satisfies condition.

----------------------------------------------------

Current pointer scans array.

If condition true

Expand boundary.

====================================================
VISUALIZATION
====================================================

Array:

[8,4,7,3,10,5]

Pivot = 5

----------------------------------------------------

i = Boundary

j = Scanner

Initially:

i = -1

j scans array

====================================================
CHEAT CODE
====================================================

Need to:

Separate elements

Group elements

Place Pivot

Think:

PARTITION POINTERS

====================================================
TIME & SPACE
====================================================

Time : O(N)

Space: O(1)

====================================================
*/

import java.util.*;
public class PartitionPointers {

    public static int partitation(int arr[]){
        int left =0,right=arr.length-1;
        int generateRandomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(arr, generateRandomIndex, right);
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        System.out.println("Final array " + Arrays.toString(arr));
        return i + 1;

    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("arr " + Arrays.toString(arr));
        System.out.println("arr i " + i);
        System.out.println("arr j " + j);
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the list of elements");
        int[] arr = new int[n];
        for (int i=0; i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("the pivot element is this " + arr[partitation(arr)]);

    }
}


/*
Question says:

✔ Partition Array

✔ Segregate Elements

✔ Move Zeroes

✔ Sort Colors

✔ Quick Sort

✔ Place Pivot

Think:

PARTITION POINTERS

boundary = correct zone

current = scanning pointer
 */