package SlidingWindow;
//Check if permutation/anagram of pattern exists in string
/*
====================================================
PROBLEM
====================================================

Given:

s1 = "ab"

s2 = "eidbaooo"

Return true if any permutation
of s1 exists in s2.

----------------------------------------------------

Permutations of "ab":

ab
ba

----------------------------------------------------

s2 contains:

"ba"

Answer = true

====================================================
CONCEPT
====================================================

Need to find whether a window
of size s1.length()

contains exactly the same
characters as s1.

----------------------------------------------------

Window Size = Fixed

Because permutation length
must equal s1 length.

====================================================
IDEA
====================================================

1. Store frequency of s1

2. Take window of same size
   in s2

3. Compare frequencies

4. Slide window

If frequencies become equal

Permutation found.

====================================================
VISUALIZATION
====================================================

s1 = "ab"

Freq:

a -> 1
b -> 1

----------------------------------------------------

s2 = "eidbaooo"

Window Size = 2

ei

id

db

ba  ← MATCH FOUND

====================================================
CHEAT CODE
====================================================

Question says:

Permutation

Anagram

Find Rearrangement

Contains Permutation

Think:

Fixed Sliding Window
+
Frequency Count

====================================================
TIME & SPACE
====================================================

Time:

O(N)

Space:

O(1)

(26 lowercase letters)

====================================================
*/

/*
====================================================
INPUT
====================================================

s1 = "ab"

s2 = "eidbaooo"

====================================================
STEP 1
====================================================

Need Frequency of s1

a -> 1
b -> 1

----------------------------------------------------

s1Freq:

[a=1,b=1]

====================================================
STEP 2
====================================================

First Window

"ei"

windowFreq:

e=1
i=1

Not Equal

====================================================
STEP 3
====================================================

Slide Window

"id"

i=1
d=1

Not Equal

====================================================
STEP 4
====================================================

Slide Window

"db"

d=1
b=1

Not Equal

====================================================
STEP 5
====================================================

Slide Window

"ba"

b=1
a=1

Equal to s1Freq

MATCH FOUND

Return true

====================================================
*/
import java.util.*;

public class StringPermutation {
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of pattern
        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        int k = s1.length();

        // First window
        for (int i = 0; i < k; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }
        // Slide window
        for (int right = k; right < s2.length(); right++) {

            // Add new character
            windowFreq[s2.charAt(right) - 'a']++;

            // Remove old character
            windowFreq[s2.charAt(right - k) - 'a']--;

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
    public  static  void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pattern string: ");
        String s1 = sc.next();

        System.out.print("Enter text string: ");
        String s2 = sc.next();

        boolean result = checkInclusion(s1, s2);

        System.out.println(
                "Permutation Exists = " + result
        );

    }
}


/*
Question says:

✔ Permutation in String

✔ Find Anagram

✔ Contains Rearrangement

✔ All Anagrams

✔ Frequency Match

Think:

Fixed Size Sliding Window

Window Size = Pattern Length

Frequency Array / HashMap

Compare Frequencies
 */


/*
1. Maximum Sum Subarray of Size K
   -> Fixed Window

2. Permutation in String
   -> Fixed Window + Frequency Count

3. Find All Anagrams
   -> Fixed Window + Frequency Count

4. Longest Substring Without Repeating
   -> Variable Window + HashSet

5. Minimum Window Substring
   -> Variable Window + Frequency Count
 */


/*
If Pattern Length is Fixed

Example:

"find anagram of abc"

Window Size = 3

Think:

Fixed Sliding Window

--------------------------------

If question says:

Longest
Smallest
At Most K

Think:

Variable Sliding Window
 */