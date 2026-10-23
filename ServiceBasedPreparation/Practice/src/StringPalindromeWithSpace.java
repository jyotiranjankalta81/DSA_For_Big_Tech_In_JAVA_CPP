import java.util.Locale;
import java.util.Scanner;

public class StringPalindromeWithSpace {

    public static boolean isPalindrome(String str1){
        String str = str1.replaceAll("[^a-zA-Z0-9]","").toLowerCase(Locale.ROOT);
        if (str==null){
            return false;
        }
        char[] chars = str.toCharArray();
        int left=0,right=chars.length-1;
        while (left<right){
            if(chars[left]== chars[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str1 = sc.nextLine();
        System.out.println("is it Palindrome or not " + isPalindrome(str1));
    }
}
