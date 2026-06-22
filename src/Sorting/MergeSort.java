package Sorting;


import java.util.*;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
//        System.out.println("left"+ left);
//        System.out.println("right"+ right);
//        System.out.println("mid"+ mid);

        // Sort left half
        mergeSort(arr, left, mid);
//        System.out.println("arr1"+ Arrays.toString(arr));

        // Sort right half
        mergeSort(arr, mid + 1, right);
//        System.out.println("arr2"+ Arrays.toString(arr));


        // Merge both sorted halves
        merge(arr, left, mid, right);
//        System.out.println("arr3"+Arrays.toString(arr));
    }

    public static void merge(int[] arr,
                             int left,
                             int mid,
                             int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        // Copy right half
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge sorted arrays
        while (i < n1 && j < n2) {

                System.out.println("indexs "+"i " + i+ "j "+j + "k " +k);
//            System.out.println("indexs " + i+ "j"+j + "k" +k);
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Remaining left elements
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Remaining right elements
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
//        System.out.println("arra final"+ Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}