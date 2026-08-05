import java.util.Scanner;

public class ValidPalindromeInaString {

    public static boolean isValidPalindrome(String str){


        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = cleaned.toCharArray();

        int left = 0;
        int right = arr.length - 1;


        while (left < right) {

            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Complete sentence: ");
        String str1 = sc.nextLine();
        System.out.println("is it valid palindrome: " + isValidPalindrome(str1));
    }

}
