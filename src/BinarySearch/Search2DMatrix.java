package BinarySearch;
/*
====================================================
CONVERT 1D INDEX
TO MATRIX POSITION
====================================================

rows = m

cols = n

----------------------------------------------------

row = mid / cols

col = mid % cols

====================================================
EXAMPLE
====================================================

Matrix:

3 rows

4 cols

----------------------------------------------------

mid = 6

row = 6 / 4 = 1

col = 6 % 4 = 2

----------------------------------------------------

matrix[1][2]

= 16

====================================================
*/

/*
====================================================
INPUT
====================================================

[
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
]

Target = 16

====================================================
TOTAL ELEMENTS
====================================================

3 * 4

= 12

====================================================
START
====================================================

left = 0

right = 11

====================================================
STEP 1
====================================================

mid = 5

row = 5/4 = 1

col = 5%4 = 1

matrix[1][1]

= 11

----------------------------------------------------

16 > 11

Search Right

left = 6

====================================================
STEP 2
====================================================

left = 6

right = 11

mid = 8

row = 8/4 = 2

col = 8%4 = 0

matrix[2][0]

= 23

----------------------------------------------------

16 < 23

Search Left

right = 7

====================================================
STEP 3
====================================================

left = 6

right = 7

mid = 6

row = 6/4 = 1

col = 6%4 = 2

matrix[1][2]

= 16

FOUND

====================================================
*/
import java.util.*;

public class Search2DMatrix {

    public static boolean searchMatrix(
            int[][] matrix,
            int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int value =
                    matrix[row][col];

            if (value == target) {
                return true;
            }

            else if (value < target) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return false;
    }

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

        for (int i = 0;
             i < rows;
             i++) {

            for (int j = 0;
                 j < cols;
                 j++) {

                matrix[i][j] =
                        sc.nextInt();
            }
        }

        System.out.print(
                "Enter target: "
        );

        int target = sc.nextInt();

        boolean found =
                searchMatrix(
                        matrix,
                        target
                );

        System.out.println(
                found
                        ? "Target Found"
                        : "Target Not Found"
        );
    }
}


/*
1. Search 2D Matrix
   -> Virtual 1D Array

2. Search 2D Matrix II
   -> Staircase Search

3. Row with Maximum Ones

4. Kth Smallest in Matrix

5. Median in Row-wise Sorted Matrix

6. Peak Element in Matrix
 */