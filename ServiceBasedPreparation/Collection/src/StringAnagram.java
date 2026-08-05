import java.util.Scanner;

public class StringAnagram {

    public static boolean isAnagram(String s,String t){

//        char[] freq = new char[26];
//
//        for(char ch:str1.toCharArray()){
//            int val = ch-'a';
//            freq[val]++;
//        }
//        for(char ch:str2.toCharArray()){
//            int val= ch-'a';
//            freq[val]--;
//            if (freq[val]<0){
//                return false;
//            }
//        }
//        return true;


        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array
        int[] freq = new int[26];

        // Step 3: Increase for s, decrease for t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Step 4: Check if all frequencies are 0
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string");
        String s1 = sc.nextLine();
        System.out.println("enter the second string");
        String s2 = sc.nextLine();
        System.out.println("is One anagram of another: " + isAnagram(s1,s2));
    }
}
