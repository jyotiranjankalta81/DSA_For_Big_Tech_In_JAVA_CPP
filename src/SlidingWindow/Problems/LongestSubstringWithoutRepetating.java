package SlidingWindow.Problems;

import  java.util.*;

public class LongestSubstringWithoutRepetating {


    public static  int findLength(String str){



        // Left boundary of the window
        int start = 0;

        // Maximum length found so far
        int maxLength = 0;

        // Character -> Last Seen Index
        HashMap<Character, Integer> map = new HashMap<>();

        // Right boundary of the window
        for (int right = 0; right < str.length(); right++) {

            char current = str.charAt(right);

            // If current character is already in the window,
            // move start to one position after its previous occurrence.
            if (map.containsKey(current)) {
                start = Math.max(start, map.get(current) + 1);
            }

            // Update the latest index of the character
            map.put(current, right);

            // Current window length
            int currentLength = right - start + 1;

            // Update answer
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;

    }
    public  static  void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String***************");
        String str = sc.nextLine();
        System.out.println("str********************* " + str);

        System.out.println("Max length of the String " + findLength(str));

    }
}
