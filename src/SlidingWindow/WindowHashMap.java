package SlidingWindow;
/*

✔ Longest Substring with K Distinct Characters

✔ Minimum Window Substring

✔ Find All Anagrams

✔ Permutation in String

✔ Longest Repeating Character Replacement

✔ Fruit Into Baskets
 */
/*
====================================================
CONCEPT
====================================================

HashMap stores:

Character -> Frequency

Example:

String:

"AABBC"

Map:

A -> 2
B -> 2
C -> 1

----------------------------------------------------

As window grows:

Add character

map.put(ch,
        map.getOrDefault(ch,0)+1)

----------------------------------------------------

As window shrinks:

Decrease frequency

If frequency becomes 0

Remove key

====================================================
WHY HASHMAP?
====================================================

Need frequency tracking.

Need distinct character count.

Need dynamic window adjustment.

====================================================
CHEAT CODE
====================================================

String

Frequency

Distinct Count

Pattern Matching

Think:

Sliding Window + HashMap

====================================================
*/
/*
====================================================
INPUT
====================================================

String:

aaabbccd

K = 2

====================================================
WINDOW
====================================================

a

Map:

a -> 1

Distinct = 1

Length = 1

----------------------------------------------------

aa

a -> 2

Distinct = 1

Length = 2

----------------------------------------------------

aaa

a -> 3

Distinct = 1

Length = 3

----------------------------------------------------

aaab

a -> 3
b -> 1

Distinct = 2

Length = 4

----------------------------------------------------

aaabb

a -> 3
b -> 2

Distinct = 2

Length = 5

----------------------------------------------------

aaabbc

a -> 3
b -> 2
c -> 1

Distinct = 3

Violation

----------------------------------------------------

Shrink Window

Remove a

a -> 2

Still 3 distinct

----------------------------------------------------

Remove a

a -> 1

Still 3 distinct

----------------------------------------------------

Remove a

a removed

Map:

b -> 2
c -> 1

Distinct = 2

Valid Again

====================================================
ANSWER
====================================================

aaabb

Length = 5

====================================================
*/


import java.util.*;

public class WindowHashMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.next();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        HashMap<Character, Integer> map =
                new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            char ch = s.charAt(right);

            // Add current character
            map.put(
                    ch,
                    map.getOrDefault(ch, 0) + 1
            );

            // Shrink if more than K distinct
            while (map.size() > k) {

                char leftChar =
                        s.charAt(left);

                map.put(
                        leftChar,
                        map.get(leftChar) - 1
                );

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen =
                    Math.max(
                            maxLen,
                            right - left + 1
                    );
        }

        System.out.println(
                "Longest Length = "
                        + maxLen
        );
    }
}


/*
1. Fixed Window
   -> Max Sum Size K

2. Variable Window
   -> Smallest Subarray Sum

3. String Permutation
   -> Frequency Array

4. Window + HashMap
   -> K Distinct Characters

5. Longest Substring Without Repeating
   -> HashSet

6. Minimum Window Substring
   -> Advanced HashMap

7. Sliding Window Maximum
   -> Monotonic Deque
 */