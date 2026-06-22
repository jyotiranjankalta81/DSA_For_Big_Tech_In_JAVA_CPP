package SlidingWindow;

/*1. Fixed Size Window
Signal Find max/min/sum/avg in subarray of FIXED size K
Keywords size K, fixed window, subarray
Time O(n)
Space O(1)
Example Max sum subarray of size K

 */


/*
====================================================
INPUT
====================================================

Array:

[2,1,5,1,3,2]

K = 3

====================================================
FIRST WINDOW
====================================================

[2,1,5]

Sum = 8

Max = 8

====================================================
MOVE WINDOW
====================================================

Remove 2

Add 1

New Window:

[1,5,1]

Sum = 7

Max = 8

====================================================
MOVE WINDOW
====================================================

Remove 1

Add 3

New Window:

[5,1,3]

Sum = 9

Max = 9

====================================================
MOVE WINDOW
====================================================

Remove 5

Add 2

New Window:

[1,3,2]

Sum = 6

Max = 9

====================================================
ANSWER
====================================================

9

====================================================
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FixedSizeWindow {
    public static ArrayList<Integer> fixedSizeWindow(int[] arr, int k){
        ArrayList<Integer> arrItems = new ArrayList<>();
        int sum = 0,left=0;
        for(int i=0;i<k;i++){
            sum = sum + arr[i];
        }
        arrItems.add(sum);
        for (int i=k;i<arr.length;i++){
            sum +=arr[i]-arr[i-k];
            arrItems.add(sum);

        }
        return arrItems;

    }
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array Size");
        int n = sc.nextInt();
        System.out.println("Enter the list of elements");
        int[] arr = new int [n];
        for(int i=0; i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("enter the window size");
        int k = sc.nextInt();

        System.out.println("List of Arrays "+ Arrays.toString(arr) + "returni array list detisl "+ fixedSizeWindow(arr,k));
    }
}


/*
====================================================
FIXED WINDOW TEMPLATE
====================================================
*/
/*
int left = 0;
int windowData = 0;

for (int right = 0; right < n; right++) {

// Add current element
windowData += arr[right];

        // Window reached size K
        if (right - left + 1 == k) {

// Process answer here

// Remove left element
windowData -= arr[left];

left++;
        }
        }
*/


/*
Question contains:

✔ Subarray of Size K
✔ Window Size K
✔ Maximum Sum of K Elements
✔ Average of K Elements
✔ Count Distinct in K Window

Think:

FIXED SIZE SLIDING WINDOW

Formula:

Add Right
→ Process Window
→ Remove Left
→ Move Window
 */