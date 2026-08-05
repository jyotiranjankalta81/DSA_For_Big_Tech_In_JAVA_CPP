import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnArray {

    public  static int[] reveerseAnArray(int [] arr){


        int left=0,right=arr.length-1;


        while (left<right){
            int leftele= arr[left];
            int rightele= arr[right];
            arr[left]=rightele;
            arr[right]=leftele;
            left++;
            right--;
        }
        return  arr;
    }

    public static String reverseAString(String str){

        int left = 0,right =str.length()-1;
        char [] stringArr = str.toCharArray();


        while (left<right){
            char leftStr = stringArr[left];
            char rightStr = stringArr[right];
            stringArr[left] = rightStr;
            stringArr[right]=leftStr;

            left++;
            right--;

        }
        return new String(stringArr);
    }

    public static void rotate(int[] arr, int k) {

        int n = arr.length;

        // Handle k greater than array length
        k = k % n;

        // Step 1: Reverse entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int left, int right) {

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public  static  void main (String [] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the length of the Array");
//        int size = sc.nextInt();
//        int[] array1 = new int[size];
//        System.out.println("enter the list of the elements");
//
//        for (int i=0;i<size;i++){
//            array1[i]= sc.nextInt();
//        }
//
//        System.out.println("The reverse array is this : " + Arrays.toString(reveerseAnArray(array1)));

//        System.out.println("enter the string here");
//        String str = sc.nextLine();
//        System.out.println("The Reverse String is this : " + reverseAString(str));


        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }


    }
}
