package TwoPointers;


import java.util.Scanner;

public class CoreTwoPointers {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size 1");
        int n = sc.nextInt();
        System.out.println("Enter the array list");
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        RemoveDuplicatesfromSortedArray removeDuplicateFromSortedArr = new RemoveDuplicatesfromSortedArray();

        System.out.println("Give me the list of the Details array  " +  removeDuplicateFromSortedArr.removeDuplicate(arr));

    }
}
