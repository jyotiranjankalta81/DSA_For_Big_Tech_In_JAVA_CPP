package HashMapAndTreeMap;

//What is an Anagram?
//Two strings are anagrams if they contain:
//
//✅ Same characters
//✅ Same frequency of each character
//✅ Order does NOT matter

//
//Examples
//Valid Anagram
//listen
//        silent
//
//Count characters:
//
//l = 1
//i = 1
//s = 1
//t = 1
//e = 1
//n = 1
//
//Both have identical counts.

//
//Not An Anagram
//        rat
//car
//
//Frequency:
//
//rat -> r=1 a=1 t=1
//car -> c=1 a=1 r=1
//
//t and c differ.
//
//        false

import java.util.*;

public class isAnagrams {
//       static boolean IsAnagram(String s, String t) {
//
//    char[] a = s.toCharArray();
//           System.out.println("Enter first string: a"+ a);
//    char[] b = t.toCharArray();
//           System.out.println("Enter first string: b"+ b);
//
//    Arrays.sort(a);
//    Arrays.sort(b);
//           System.out.println("Enter first string: a"+ a);
//           System.out.println("Enter first string: b"+ b);
//
//    return Arrays.equals(a, b);
//          }


    static boolean IsAnagram(String s, String t) {

//        time complexity is O(N) here

//        if (s.length() != t.length())
//            return false;
//
//        int[] freq = new int[26];
//                   System.out.println("Enter first string: freq"+ Arrays.toString(freq));
//
//        for (char c : s.toCharArray()) {
//            freq[c - 'a']++;
//
//                       System.out.println("Enter first string: a"+ Arrays.toString(freq));
//
//        }
//
//        for (char c : t.toCharArray()) {
//            freq[c - 'a']--;
//                       System.out.println("Enter first string: b"+ Arrays.toString(freq));
//        }
//                   System.out.println("Enter first string: c"+ Arrays.toString(freq));
//
//        for (int count : freq) {
//            if (count != 0)
//                return false;
//        }
//
//        return true;

        Map<Character, Integer> freq = new HashMap<>();

                   System.out.println("Enter first string: c"+ freq);
        for(char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println("Enter first string: c1"+ freq);
        for(char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        System.out.println("Enter first string: c2"+ freq);

        for(int count : freq.values()) {
            if(count != 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        if (IsAnagram(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();


}
}