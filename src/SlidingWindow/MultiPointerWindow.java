package SlidingWindow;

/*
====================================================
CONCEPT
====================================================

Normal Sliding Window

Uses:

left
right

----------------------------------------------------

Multi-Pointer Window

Uses:

left
right

PLUS

Extra pointers/counters

to track additional conditions.

====================================================
WHERE USED?
====================================================

✔ Minimum Window Substring

✔ Longest Repeating Character
  Replacement

✔ Fruit Into Baskets

✔ Subarrays with K Distinct

✔ Count Nice Subarrays

✔ Count Subarrays with Sum K

====================================================
IDEA
====================================================

Sometimes

left/right alone

cannot solve the problem.

Need extra information.

Examples:

Frequency Map

Distinct Count

Max Frequency

Zero Count

Odd Count

====================================================
EXAMPLE
====================================================

Longest Repeating Character
Replacement

String:

AABABBA

K = 1

----------------------------------------------------

Can replace at most 1 char.

Need:

left
right
maxFreq

Three moving values.

That's why it's called
Multi-Pointer Window.

====================================================
CHEAT CODE
====================================================

Sliding Window

+

Extra State Tracking

=

Multi Pointer Window

====================================================
*/

/*
====================================================
INPUT
====================================================

AABABBA

K = 1

====================================================
VARIABLES
====================================================

left

right

maxFreq

HashMap

====================================================
STEP 1
====================================================

Window:

A

Map:

A -> 1

maxFreq = 1

Window Size = 1

Valid

Answer = 1

====================================================
STEP 2
====================================================

AA

Map:

A -> 2

maxFreq = 2

Window Size = 2

Need Replacement:

2 - 2 = 0

Valid

Answer = 2

====================================================
STEP 3
====================================================

AAB

Map:

A -> 2
B -> 1

maxFreq = 2

Window Size = 3

Replacement Needed:

3 - 2 = 1

Valid

Answer = 3

====================================================
STEP 4
====================================================

AABA

Map:

A -> 3
B -> 1

maxFreq = 3

Window Size = 4

Replacement Needed:

4 - 3 = 1

Valid

Answer = 4

====================================================
STEP 5
====================================================

AABAB

Map:

A -> 3
B -> 2

maxFreq = 3

Window Size = 5

Replacement Needed:

5 - 3 = 2

Violation

----------------------------------------------------

Shrink

Remove left A

Window:

ABAB

Valid Again

====================================================
ANSWER
====================================================

4

====================================================
*/
/*
====================================================
MOST IMPORTANT FORMULA
====================================================

windowSize - maxFreq

----------------------------------------------------

Meaning:

How many characters need
replacement?

----------------------------------------------------

Example:

AABAB

Window Size = 5

maxFreq(A) = 3

Replacement Needed

= 5 - 3

= 2

====================================================
*/



import java.util.*;

public class MultiPointerWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.next();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        HashMap<Character, Integer> map =
                new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int answer = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            char ch = s.charAt(right);

            map.put(
                    ch,
                    map.getOrDefault(ch, 0) + 1
            );

            maxFreq =
                    Math.max(
                            maxFreq,
                            map.get(ch)
                    );

            while ((right - left + 1)
                    - maxFreq > k) {

                char leftChar =
                        s.charAt(left);

                map.put(
                        leftChar,
                        map.get(leftChar) - 1
                );

                left++;
            }

            answer =
                    Math.max(
                            answer,
                            right - left + 1
                    );
        }

        System.out.println(
                "Longest Length = "
                        + answer
        );
    }
}