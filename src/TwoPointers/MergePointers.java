package TwoPointers;
/*
====================================================
CONCEPT
====================================================

Merge Pointers are used when

two sorted arrays/lists

need to be processed together.

----------------------------------------------------

Pointer i

Array 1

----------------------------------------------------

Pointer j

Array 2

====================================================
WHERE USED?
====================================================

✔ Merge Two Sorted Arrays

✔ Merge Sort

✔ Intersection of Arrays

✔ Union of Arrays

✔ Merge Intervals

✔ K-way Merge (Priority Queue)

====================================================
IDEA
====================================================

Compare current elements

Take smaller one

Move its pointer

----------------------------------------------------

Continue until

one array finishes.

====================================================
VISUALIZATION
====================================================

Array1:

[1,4,7]

Array2:

[2,5,8]

----------------------------------------------------

Compare

1 vs 2

Take 1

Move i

----------------------------------------------------

Compare

4 vs 2

Take 2

Move j

----------------------------------------------------

Compare

4 vs 5

Take 4

Move i

====================================================
CHEAT CODE
====================================================

Two Sorted Arrays

Need Combined Result

Think:

MERGE POINTERS

====================================================
TIME & SPACE
====================================================

Time:

O(N + M)

Space:

O(N + M)

====================================================
*/
/*
====================================================
INPUT
====================================================

arr1

[1,4,7]

arr2

[2,5,8]

====================================================
START
====================================================

i = 0

j = 0

result = []

====================================================
STEP 1
====================================================

1 vs 2

Take 1

result:

[1]

i++

====================================================
STEP 2
====================================================

4 vs 2

Take 2

result:

[1,2]

j++

====================================================
STEP 3
====================================================

4 vs 5

Take 4

result:

[1,2,4]

i++

====================================================
STEP 4
====================================================

7 vs 5

Take 5

result:

[1,2,4,5]

j++

====================================================
STEP 5
====================================================

7 vs 8

Take 7

result:

[1,2,4,5,7]

i++

====================================================
ARRAY 1 FINISHED
====================================================

Copy remaining

8

====================================================
FINAL
====================================================

[1,2,4,5,7,8]

====================================================
*/
import java.util.*;
public class MergePointers {
    public static ArrayList<Integer> mergeArray(int[] arr, int[] arr1){
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while (i<arr.length && j<arr1.length){
            if(arr[i]<arr1[j]){
                result.add(arr[i]);
                i++;
            }else{
                result.add(arr1[j]);
                j++;
            }
        }
        while (i<arr.length){
            result.add(arr[i]);
            i++;
        }
        while (j<arr1.length){
            result.add(arr1[j]);
            j++;
        }
        
        return result;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size 1");
        int n = sc.nextInt();
        System.out.println("Enter the array list");
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the array list 2");
        int[] arr1 = new int[n];
        for (int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        
        System.out.println("merge Array  " + mergeArray(arr,arr1));



    }
}
