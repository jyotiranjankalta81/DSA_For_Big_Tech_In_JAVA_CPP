import java.util.Arrays;

public class RotateAnArrayKtimes {


    public static int [] rotateKTimes(int[] arr,int k){


        int finalK= k%arr.length;
        reverseArr(arr,0,arr.length-1);
        reverseArr(arr,finalK,arr.length-1);
        reverseArr(arr,0,finalK-1);
        return arr;

    }

    public static int [] reverseArr(int[] arr,int left,int right){
        while (left<=right){
            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,7,9};

        String str = Arrays.toString(rotateKTimes(arr,7));

        System.out.println("values " + str
        );
    }
}
