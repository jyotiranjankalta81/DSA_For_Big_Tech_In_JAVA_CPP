import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class KadensAlgorithm {


    public static int maximumSum(int[] arr){
        int currentSum =arr[0];
        int maxSum=arr[0];
        for (int i=0;i<arr.length;i++){
            currentSum=Math.max(arr[i],currentSum+arr[i]);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array size ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter list of elements");
        for (int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }

        int target =5;

//        targetSum sums = new targetSum();
//
//        int[] arr2 = sums.targetSumHashMap(arr,target);

//        RotateAnArrayKtimes rotate = new RotateAnArrayKtimes();
//        int []rotatation =  rotate.rotateKTimes(arr,target);
//        missingNo1ToN oneton= new missingNo1ToN();
//        int value = oneton.missingNo(arr);



//        System.out.println("max sum of the array: " + value);


    }
}
