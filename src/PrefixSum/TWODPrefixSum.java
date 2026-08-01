package PrefixSum;

/*
====================================================
CONCEPT
====================================================

1D Prefix Sum

Answers:

Range Sum in Array

----------------------------------------------------

2D Prefix Sum

Answers:

Rectangle Sum in Matrix

====================================================
PROBLEM
====================================================

Matrix

1  2  3
4  5  6
7  8  9

----------------------------------------------------

Find Sum of Rectangle

(1,1) to (2,2)

====================================================

Rectangle

5 6
8 9

====================================================

Answer

5+6+8+9

= 28

====================================================
BRUTE FORCE
====================================================

Loop inside rectangle

Every Query

----------------------------------------------------

Time

O(rows * cols)

per query

====================================================
OPTIMAL
====================================================

Build 2D Prefix

----------------------------------------------------

Preprocessing

O(rows * cols)

----------------------------------------------------

Query

O(1)

====================================================
*/

/*
====================================================
MATRIX
====================================================

1  2  3
4  5  6
7  8  9

====================================================
PREFIX MATRIX
====================================================

1   3    6

5   12   21

12  27   45

====================================================

Meaning

prefix[i][j]

=

sum of rectangle

(0,0)

to

(i,j)

====================================================
*/


/*
====================================================
BUILD PREFIX
====================================================

prefix[i][j]

=

matrix[i][j]

+

top

+

left

-

overlap

====================================================

prefix[i][j]

=

matrix[i][j]

+

prefix[i-1][j]

+

prefix[i][j-1]

-

prefix[i-1][j-1]

====================================================
WHY SUBTRACT?
====================================================

Overlap counted twice.

====================================================
*/

/*
====================================================
QUERY RECTANGLE
====================================================

(r1,c1)

to

(r2,c2)

====================================================

ANSWER

=

prefix[r2][c2]

-

prefix[r1-1][c2]

-

prefix[r2][c1-1]

+

prefix[r1-1][c1-1]

====================================================
INCLUSION EXCLUSION
====================================================

Take Full Area

Remove Top

Remove Left

Add Overlap Back

====================================================
*/


import java.util.*;

public class TWODPrefixSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        int[][] matrix =
                new int[rows][cols];

        System.out.println(
                "Enter matrix:"
        );

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] =
                        sc.nextInt();
            }
        }

        /*
        ============================================
        BUILD PREFIX
        ============================================
        */

        int[][] prefix =
                new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {

                prefix[i][j] =
                        matrix[i - 1][j - 1]
                                + prefix[i - 1][j]
                                + prefix[i][j - 1]
                                - prefix[i - 1][j - 1];
            }
        }

        System.out.print(
                "Enter r1 c1 r2 c2: "
        );

        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        /*
        ============================================
        RECTANGLE SUM QUERY
        ============================================
        */

        int answer =
                prefix[r2 + 1][c2 + 1]
                        - prefix[r1][c2 + 1]
                        - prefix[r2 + 1][c1]
                        + prefix[r1][c1];

        System.out.println(
                "Rectangle Sum = "
                        + answer
        );
    }
}