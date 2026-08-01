package PrefixSum;

/*
====================================================
PROBLEM
====================================================

Given:

nums[]

and integer k

Check whether there exists a
continuous subarray

having:

length >= 2

and

sum % k == 0

====================================================
EXAMPLE
====================================================

nums:

[23,2,4,6,7]

k = 6

====================================================

Subarray:

[2,4]

sum = 6

6 % 6 = 0

Answer:

TRUE

====================================================
*/
/*
====================================================
PREFIX SUM
====================================================

Suppose:

prefix[i] % k

=

prefix[j] % k

====================================================

Then

(prefix[j] - prefix[i])

% k

=

0

====================================================

Meaning

Subarray

(i+1 ... j)

is divisible by k

====================================================
*/
import java.util.*;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(
            int[] nums,
            int k) {

        HashMap<Integer, Integer> map =
                new HashMap<>();

        // remainder 0 before array starts
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int remainder =
                    prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {

                int prevIndex =
                        map.get(remainder);

                // Length must be >= 2
                if (i - prevIndex >= 2) {
                    return true;
                }
            }

            else {

                // Store FIRST occurrence only
                map.put(
                        remainder,
                        i
                );
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");

        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println(
                "Enter elements:"
        );

        for (int i = 0; i < n; i++) {

            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");

        int k = sc.nextInt();

        boolean ans =
                checkSubarraySum(nums, k);

        System.out.println(
                "Answer = " + ans
        );
    }
}