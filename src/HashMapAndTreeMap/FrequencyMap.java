package HashMapAndTreeMap;

import java.util.*;

//if you see keyword
//Count occurrences
//Frequency
//        Duplicate
//Most frequent
//Anagram
//Majority element
//Top K frequent
//Character count



// Find duplicate
//Find unique
//Count frequency
//Most frequent element
//        Anagram
//Majority element
//Top K frequent
public class FrequencyMap {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 4};

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println(freq);
    }
}
