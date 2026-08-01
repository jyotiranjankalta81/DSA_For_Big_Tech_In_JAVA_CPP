package BinarySearch;

/*
====================================================
TRY EVERY SPEED
====================================================

K = 1

K = 2

K = 3

...

K = 11

----------------------------------------------------

Check each speed.

Time:

O(maxPile × N)

Too Slow

====================================================
*/

/*
====================================================
SPEED = 1
====================================================

Possible?

Maybe No

====================================================
SPEED = 2
====================================================

Maybe No

====================================================
SPEED = 4
====================================================

Yes

====================================================
SPEED = 5
====================================================

Yes

====================================================
SPEED = 6
====================================================

Yes

====================================================

Notice:

FALSE FALSE FALSE TRUE TRUE TRUE

====================================================

This pattern means

Binary Search Possible

====================================================
*/
//Speed
//
//1 2 3 4 5 6 7 8 9
//
//F F F T T T T T T
//
//          ^
//
//Minimum Valid Answer

/*
====================================================
BINARY SEARCH ON ANSWER
====================================================

Need Search Space

----------------------------------------------------

Minimum Speed

= 1

----------------------------------------------------

Maximum Speed

= max pile

====================================================

mid = candidate answer

----------------------------------------------------

Check:

Can we finish in H hours?

====================================================

YES
====================================================

Try smaller answer

right = mid - 1

====================================================

NO
====================================================

Need larger answer

left = mid + 1

====================================================
*/
public class BinarySearchOnAnswer {

    // Check if speed is possible
    public static boolean canFinish(
            int[] piles,
            int h,
            int speed) {

        long hours = 0;

        for (int pile : piles) {

            // Ceiling Division
            hours +=
                    (pile + speed - 1)
                            / speed;
        }

        return hours <= h;
    }

    public static int minEatingSpeed(
            int[] piles,
            int h) {

        int left = 1;

        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {

            int mid =
                    left +
                            (right - left) / 2;

            if (canFinish(
                    piles,
                    h,
                    mid)) {

                answer = mid;

                // Try smaller answer
                right = mid - 1;
            }

            else {

                // Need bigger answer
                left = mid + 1;
            }
        }

        return answer;
    }
}
