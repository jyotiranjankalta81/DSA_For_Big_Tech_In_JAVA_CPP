package TreeSet;
/*
====================================================
KTH SMALLEST ELEMENT
====================================================

Array:

[50,10,30,20,40]

Sorted:

[10,20,30,40,50]

------------------------------------

1st Smallest = 10

2nd Smallest = 20

3rd Smallest = 30

4th Smallest = 40

5th Smallest = 50

====================================================
KTH LARGEST ELEMENT
====================================================

Sorted:

[10,20,30,40,50]

1st Largest = 50

2nd Largest = 40

3rd Largest = 30

====================================================
WHY TREESET ?
====================================================

TreeSet automatically stores:

Unique
+
Sorted

Example:

Input:

50 10 30 20 40

TreeSet:

[10,20,30,40,50]

====================================================
HOW TO FIND KTH SMALLEST?
====================================================

Traverse from beginning.

k=3

10 -> count=1

20 -> count=2

30 -> count=3

Answer = 30

====================================================
HOW TO FIND KTH LARGEST?
====================================================

Traverse from end.

50 -> count=1

40 -> count=2

30 -> count=3

Answer = 30

====================================================
TIME COMPLEXITY
====================================================

Insert:

O(log N)

Find kth:

O(K)

====================================================
INTERVIEW NOTE
====================================================

TreeSet removes duplicates.

Array:

[10,10,20,30]

TreeSet:

[10,20,30]

If duplicates matter,
don't use TreeSet.

Use PriorityQueue instead.

====================================================
*/
import java.util.*;

public class KthSmallestOrLargest {

    public  static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        System.out.println("Enter the Size of the arrray");
        int n = sc.nextInt();
        System.out.println("Enter the list of integer");
        for(int i=0; i<n;i++){
            set.add(sc.nextInt());
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Kth Smallest
        int count = 0;
        Integer kthSmallest = null;

        for(int num : set) {
            count++;

            if(count == k) {
                kthSmallest = num;
                break;
            }
        }

        // Kth Largest
        count = 0;
        Integer kthLargest = null;

        for(int num : set.descendingSet()) {
            count++;

            if(count == k) {
                kthLargest = num;
                break;
            }
        }

        System.out.println("Kth Smallest = " + kthSmallest);
        System.out.println("Kth Largest = " + kthLargest);
    }
}
