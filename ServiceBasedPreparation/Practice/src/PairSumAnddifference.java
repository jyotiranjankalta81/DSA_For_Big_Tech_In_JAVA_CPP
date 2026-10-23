import java.util.*;

public class PairSumAnddifference {

    public static List<List<Integer>> pairSum (int[] arr, int target){


        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();

        System.out.println("length "+ arr.length);

        for(int i=0;i<arr.length;i++){
            int complement = target-arr[i];
            if(set.contains(complement)){
                pairs.add(Arrays.asList(arr[i],complement));
            }
            set.add(arr[i]);

        }
        return pairs;
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

        System.out.println("Pair Sum " + pairSum(arr,10));
    }
}
