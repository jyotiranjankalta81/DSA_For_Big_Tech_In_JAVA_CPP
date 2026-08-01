package BinarySearch;

import java.util.*;

public class CoreBinarySearch {
    public  static  int binarySearch(int arr[],int k){
        int left=0,right=arr.length;
        if(arr[right/2]<k){
            left=right/2;
        }else if(arr[right/2]>k){
            right=right/2;

        }else if(arr[right/2]== k){
            return right/2;
        }

        System.out.println("enter the index :"+ left + " "+ right);

        for(int i=left;i<right;i++){
            if(arr[i]==k){
                return i;
            }
        }
        return 0;
    }


    public static int binarySearchV1(
            int[] arr,
            int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            // Safe mid calculation
            int mid =
                    left +
                            (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (target > arr[mid]) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return -1;
    }
    public  static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n = sc.nextInt();
        System.out.println("Enter the list of the array");
        int[] arr = new int[n];
        for (int i=0; i<n; i++){

            arr[i]= sc.nextInt();
        }

//        System.out.println("enter the element:");
//        int k = sc.nextInt();
//        System.out.println("is element find : "+ binarySearch(arr,k));

//        SearchRotatedArray searchrottated= new SearchRotatedArray();


        int peakIndex = PeakFinding.findPeak(arr);

        System.out.println("Peak Index : " + peakIndex);
        System.out.println("Peak Element : " + arr[peakIndex]);






    }
}
