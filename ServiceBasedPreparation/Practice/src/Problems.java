import java.util.Arrays;

/*

Given a string s, reverse the string without using built-in reverse methods.
 */
class Problems{

    public static String stringReversal(String str) {

        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
    public static void main (String[] args){
        String str1 = "hello";
        System.out.println("this is the first problem. " +str1+ " then reversal string " +stringReversal(str1) );
    }
}