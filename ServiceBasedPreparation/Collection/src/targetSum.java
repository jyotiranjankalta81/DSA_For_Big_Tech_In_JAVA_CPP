import java.util.HashMap;

public class targetSum {


    public static int[] targetSumHashMap(int[] arr,int target){


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int complement = target-arr[i];

            if(map.containsKey(complement)){
                return new int[]{arr[i],complement};
            }

            map.put(arr[i],i);
        }

        return new int[]{};



    }
}
