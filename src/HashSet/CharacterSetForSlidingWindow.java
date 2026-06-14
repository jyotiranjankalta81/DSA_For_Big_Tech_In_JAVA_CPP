package HashSet;
/*
====================================================
LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
====================================================

String:

"abcabcbb"

Need:

Longest substring with
all unique characters.

Answer:

"abc"

Length = 3

====================================================
SLIDING WINDOW IDEA
====================================================

Maintain a window.

left  -> start
right -> end

Use HashSet to store
characters currently
inside the window.

====================================================
START
====================================================

String:

abcabcbb

Window:

[]

Set:

{}

====================================================
RIGHT = 0
====================================================

Character:

a

Set:

{}

a not present

Add a

Window:

[a]

Length = 1

====================================================
RIGHT = 1
====================================================

Character:

b

Add b

Window:

[a,b]

Length = 2

====================================================
RIGHT = 2
====================================================

Character:

c

Add c

Window:

[a,b,c]

Length = 3

====================================================
RIGHT = 3
====================================================

Character:

a

Already exists.

Duplicate found.

Cannot expand window.

====================================================
REMOVE FROM LEFT
====================================================

Remove:

a

Move left forward.

Window:

[b,c]

Now a no longer exists.

Add a

Window:

[b,c,a]

Length still = 3

====================================================
KEY IDEA
====================================================

Duplicate?

Keep removing from left
until duplicate disappears.

====================================================
WHY HASHSET?
====================================================

contains()

O(1)

Fast duplicate check.

====================================================
WINDOW RULE
====================================================

Duplicate found?

remove from left

------------------------------------

No duplicate?

expand right

====================================================
TIME COMPLEXITY
====================================================

Each character enters
window once.

Each character leaves
window once.

Total:

O(N)

====================================================
INTERVIEW CHEAT CODE
====================================================

Need:

Unique characters
Duplicate detection
Sliding window

Think:

HashSet<Character>

====================================================
*/

import java.util.*;

public class CharacterSetForSlidingWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            while(set.contains(ch)) {

                set.remove(s.charAt(left));

                left++;
            }

            set.add(ch);

            maxLength =
                    Math.max(maxLength,
                            right - left + 1);
        }

        System.out.println(
                "Longest Length = " + maxLength
        );
    }
}