//Problem
//
//Given an array and a target, return the indices of two numbers whose sum equals the target.
//
//nums = [2, 7, 11, 15]
//target = 9
//
//Output: [0, 1]


//Interview Cheat Code
//
//        👉 While traversing the array:
//
//        Find the complement
//
//        complement = target - nums[i];
//        Check if complement already exists in HashMap.
//        If yes → answer found.
//        Otherwise store current number and its index.
//
//
package HashMapAndTreeMap;
import java.util.*;




public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
            }

                map.put(nums[i], i);
        }

            return new int[] {};
    }

    public static void main(String[] args) {

//            int[] nums = {2, 7, 11, 15};
//            int target = 9;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter numbers:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(nums));

        System.out.println("Enter target:");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
        sc.close();
    }
}

