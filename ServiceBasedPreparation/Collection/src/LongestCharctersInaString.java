import java.util.HashMap;

public class LongestCharctersInaString {

    public static String longestNonRepetingString(String str){
        int left=0;
        int max=0;
        int maxStart = 0;


        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length()-1;i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);

            }
            map.put(ch,i);
            int currentLength = i - left + 1;
// for maximun length
            max = Math.max(
                    max,
                    currentLength
            );
            // Found a bigger window
            if (currentLength > max) {

                max= currentLength;
                maxStart = left;
            }

        }
        return str.substring(
                maxStart,
                maxStart + max);
    }

    public static void main(String[] args) {

        System.out.println(longestNonRepetingString("abcabcbb"));
        System.out.println(longestNonRepetingString("bbbbb"));
        System.out.println(longestNonRepetingString("pwwkew"));
    }
}
