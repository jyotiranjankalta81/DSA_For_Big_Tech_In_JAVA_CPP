package PrefixSum;
/*
====================================================
RANGE SUM
====================================================

L to R

====================================================

sum(L,R)

=

prefix[R]
-
prefix[L-1]

====================================================

Example:

Array:

[2,4,6,8,10]

Prefix:

[2,6,12,20,30]

====================================================

Find Sum

index 1 to 3

----------------------------------------------------

4 + 6 + 8

= 18

====================================================

prefix[3]

-

prefix[0]

----------------------------------------------------

20 - 2

= 18

====================================================
*/


/*
====================================================
INPUT
====================================================

Array:

[2,4,6,8,10]

====================================================
BUILD PREFIX
====================================================

prefix[0] = 2

----------------------------------------------------

prefix[1]

= prefix[0] + 4

= 6

----------------------------------------------------

prefix[2]

= 6 + 6

= 12

----------------------------------------------------

prefix[3]

= 12 + 8

= 20

----------------------------------------------------

prefix[4]

= 20 + 10

= 30

====================================================
PREFIX ARRAY
====================================================

[2,6,12,20,30]

====================================================
QUERY
====================================================

L = 1

R = 3

====================================================

Answer

=

prefix[3]
-
prefix[0]

=

20 - 2

=

18

====================================================
*/

import java.util.*;

public class OneDPrefixSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build Prefix Sum
        int[] prefix = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {

            prefix[i] =
                    prefix[i - 1]
                            + arr[i];
        }

        System.out.println(
                "Prefix Array:"
        );

        System.out.println(
                Arrays.toString(prefix)
        );

        System.out.print(
                "Enter Left Index: "
        );

        int L = sc.nextInt();

        System.out.print(
                "Enter Right Index: "
        );

        int R = sc.nextInt();

        int sum;

        if (L == 0) {

            sum = prefix[R];

        } else {

            sum =
                    prefix[R]
                            - prefix[L - 1];
        }

        System.out.println(
                "Range Sum = " + sum
        );
    }
}

/*
====================================================
PREFIX[i]
====================================================

Sum from

0 to i

====================================================

Range Sum

L to R

====================================================

Remove unwanted left part

----------------------------------------------------

prefix[R]

-

prefix[L-1]

====================================================
*/


/*
1. Range Sum Query
   -> Prefix Sum

2. Subarray Sum Equals K
   -> Prefix + HashMap

3. Count Subarrays
   -> Prefix + Frequency Map

4. Equilibrium Index

5. Product Except Self

6. Difference Array

7. 2D Prefix Sum
 */