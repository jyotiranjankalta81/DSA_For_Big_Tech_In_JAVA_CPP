import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[]  productArrayExceeptSelfWithOutDivision(int[] arr){

        int[] answer=new int[arr.length];
        int prefix=1;
        int suffix=1;

        for(int i=0;i<arr.length;i++){
            answer[i] = prefix;
            prefix = prefix * arr[i];

        }
        for (int i=arr.length-1;i>=0;i--){
            answer[i] = answer[i] * suffix;
            suffix = suffix * arr[i];
        }


        return answer;
    }

    public static void main(String[] args){
        int [] arr ={1,2,3,4};
        System.out.println("Total Prodcut of the arr is " + Arrays.toString(productArrayExceeptSelfWithOutDivision(arr)));
    }
}
