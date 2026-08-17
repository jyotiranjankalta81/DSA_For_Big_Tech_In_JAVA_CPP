import java.util.*;

public class PairSum {

    public static List<List<Integer>> pairSumHashMap(
            int[] arr,
            int target) {

        Set<Integer> seen = new HashSet<>();

        List<List<Integer>> pairs = new ArrayList<>();

        for (int num : arr) {

            int complement = target - num;

            if (seen.contains(complement)) {

                pairs.add(
                        Arrays.asList(complement, num)
                );
            }

            seen.add(num);
        }

        return pairs;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15, 3, 6};

        System.out.println(
                pairSumHashMap(arr, 9)
        );
    }
}