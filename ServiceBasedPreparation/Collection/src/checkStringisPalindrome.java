import java.util.Scanner;

public class checkStringisPalindrome {


    public static boolean ispalindrome(String str){

        int left=0,right=str.length()-1;
        char [] chs = str.toCharArray();
        while (left<right){
            if (chs[left] != chs[right]) {
                return false;

            }
            left++;
            right--;
        }

        return true;
    }


    public static void main (String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the Complete sentence");
//        String str1 = sc.nextLine();
//        System.out.println("the sentence is palindrome or not " + ispalindrome(str1));

        System.out.println(ispalindrome("madam"));
        System.out.println(ispalindrome("racecar"));
        System.out.println(ispalindrome("hello"));
    }
}
