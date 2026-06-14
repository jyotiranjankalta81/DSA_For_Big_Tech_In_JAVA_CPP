//HashMap Pattern: Track First Occurrence Index
//
//This pattern is useful when you want to remember where an element first appeared.

package HashMapAndTreeMap;
import java.util.*;

public class TrackFirstOccuranceIndex {



        public static void main(String[] args) {

            int[] nums = {5, 2, 8, 2, 9, 5};

            HashMap<Integer, Integer> firstIndex = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (!firstIndex.containsKey(nums[i])) {
                    firstIndex.put(nums[i], i);
                }
            }

            System.out.println(firstIndex);
        }

}

//Example
//
//Input:
//[5, 2, 8, 2, 9, 5]


//5 -> 0 2 -> 1 8 -> 2 9 -> 4
//Shortcut Using putIfAbsent()

//for (int i = 0; i < nums.length; i++) {
//        firstIndex.putIfAbsent(nums[i], i);
//}

//Interview Uses
//1. First Non-Repeating Character
//"leetcode"
//
//Track first index and frequency.
//
//2. Two Sum
//
//Store:
//
//number -> index
//3. Longest Substring Without Repeating Characters
//
//Store:
//
//character -> last seen index
//4. Find First Duplicate
//if(map.containsKey(nums[i])) {
//        System.out.println(
//        "First seen at index " + map.get(nums[i])
//    );
//            }