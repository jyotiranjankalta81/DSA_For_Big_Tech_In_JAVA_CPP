package TreeSet;

import java.util.*;
public class CountOfElementsInRange {

    public static  void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the elements");
        int n = sc.nextInt();
        System.out.println("Enter the list of the elements");
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(sc.nextInt());
        }
        System.out.println("Enter the left range");
        int left = sc.nextInt();
        System.out.println("Enter the right range");
        int right = sc.nextInt();
        // Elements in [lo, hi]:
        NavigableSet<Integer> sub = set.subSet(left, true, right, true);
        int count = sub.size();
        System.out.println("sub of Elements:"+sub);
        System.out.println("Count of Elements:"+count);


    }
}
/*
====================================================
CLOSEST VALUE TO TARGET
====================================================

Question:

TreeSet:

[10,20,30,40,50]

Target:

28

Need:

Which number is closest to 28 ?

----------------------------------------------------

Distance from 28

10 -> 18

20 -> 8

30 -> 2

40 -> 12

50 -> 22

Answer:

30

====================================================
NAIVE APPROACH
====================================================

Traverse all elements.

Find minimum difference.

Time:

O(N)

====================================================
TREESET SUPERPOWER
====================================================

Use:

floor()
ceiling()

----------------------------------------------------

floor(x)

Largest value <= x

----------------------------------------------------

ceiling(x)

Smallest value >= x

====================================================
EXAMPLE
====================================================

Set:

[10,20,30,40,50]

Target:

28

----------------------------------------------------

floor(28)

20

----------------------------------------------------

ceiling(28)

30

----------------------------------------------------

Only compare:

20 and 30

Why?

Because every other value
is farther away.

----------------------------------------------------

|28-20| = 8

|30-28| = 2

Answer:

30

====================================================
ANOTHER EXAMPLE
====================================================

Set:

[10,20,30,40,50]

Target:

22

floor(22) = 20

ceiling(22) = 30

----------------------------------------------------

|22-20| = 2

|30-22| = 8

Answer:

20

====================================================
EDGE CASES
====================================================

Target = 5

floor(5) = null

ceiling(5) = 10

Answer = 10

----------------------------------------------------

Target = 100

floor(100) = 50

ceiling(100) = null

Answer = 50

====================================================
TIME COMPLEXITY
====================================================

floor()   O(log N)

ceiling() O(log N)

Total:

O(log N)

====================================================
INTERVIEW CHEAT CODE
====================================================

Closest Number

Think:

floor(target)
ceiling(target)

Compare distances.

====================================================
*/
/*

// Pattern 3: Closest value to target
TreeSet<Integer> values = new TreeSet<>();
// ... populate ...
Integer floor = values.floor(target);    // closest ≤ target
Integer ceil  = values.ceiling(target);  // closest ≥ target
// Choose closer:
int closest;
if (floor == null) closest = ceil;
else if (ceil == null) closest = floor;
else closest = (target - floor <= ceil - target) ? floor : ceil;
*
 */