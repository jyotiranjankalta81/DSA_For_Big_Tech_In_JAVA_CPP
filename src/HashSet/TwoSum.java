package HashSet;
/*
====================================================
TWO SUM USING HASHSET
====================================================

Question:

Array:

[2,7,11,15]

Target:

9

Need:

Find if any pair
sums to target.

Answer:

2 + 7 = 9

====================================================
IDEA
====================================================

For every number:

Required = target - num

Check:

Have we already seen
the required number?

If YES

Pair found.

====================================================
EXAMPLE
====================================================

Array:

[2,7,11,15]

Target = 9

====================================================
STEP 1
====================================================

Current Number:

2

Required:

9 - 2 = 7

Set:

{}

7 exists?

NO

Add 2

Set:

{2}

====================================================
STEP 2
====================================================

Current Number:

7

Required:

9 - 7 = 2

Set:

{2}

2 exists?

YES

Pair Found

(2,7)

====================================================
WHY HASHSET?
====================================================

contains()

O(1)

Fast lookup.

====================================================
VISUALIZATION
====================================================

Target = 10

Array:

[3,5,8,2]

------------------------------------

Current = 3

Need = 7

Set = {}

Add 3

------------------------------------

Current = 5

Need = 5

Set = {3}

Not found

Add 5

------------------------------------

Current = 8

Need = 2

Set = {3,5}

Not found

Add 8

------------------------------------

Current = 2

Need = 8

Set = {3,5,8}

Found

Pair:

(8,2)

====================================================
TIME COMPLEXITY
====================================================

Each element processed once.

contains() -> O(1)

Total:

O(N)

====================================================
INTERVIEW CHEAT CODE
====================================================

Need:

target - current

If already seen

Answer found.

HashSet stores
previously seen numbers.

====================================================
*/


import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        boolean found = false;

        for(int num : nums) {
            System.out.println("num*************************"+ num);

            int need = target - num;

            if(set.contains(need)) {

                System.out.println(
                        "Pair Found: " +
                                need + " + " + num +
                                " = " + target
                );

                found = true;
                break;
            }

            set.add(num);
        }

        if(!found) {
            System.out.println("No Pair Found");
        }
    }
}