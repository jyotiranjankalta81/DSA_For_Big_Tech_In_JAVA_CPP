package Problems;



// Given an integer array nums sorted in non-decreasing order,
// return an array of the squares of each number sorted in non-decreasing order.

// Input: nums = [-7,-3,-1,    4,8,12]

//left=0; right =left+1;
//49,144

//49,9,1,16,64,144

//1,9,16,49,64,144


//brute force
//make square root of each element
//then sort the entire array in increasing order

//for optimise approach

//square and binary sort



// Output: [1,9,16,49,64,144]

import java.util.Arrays;

public class Test1 {

    public static int[] squeareRootBruteForce(int [] arr){


        int[] squarerootValue = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            squarerootValue[i]= arr[i]*arr[i];
        }
        Arrays.sort(squarerootValue);
//        O(N) + nlogn

        return squarerootValue;
    }

    public static void main(String[] args){
        int[] arrInput = {-7,-3,-1,4,8,12};
        int [] result= squeareRootBruteForce(arrInput);
        System.out.println("the final arr is  " + Arrays.toString(result));
    }


}
