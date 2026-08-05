import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {

    public static  int[] removeDuplicates(int[] arr){
        int slow=0;
        if(arr.length==0){
            return new int[]{};
        }

        for (int i=1;i<arr.length;i++){
            if(arr[slow]!=arr[i]){
                slow++;
                arr[slow]= arr[i];
            }
        }

        return Arrays.copyOf(arr,slow+1);
    }

    public  static Integer[] removeDuplicateInUnsortedArray(Integer[] arr){
        HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        return set.toArray(new Integer[0]);
    }

    public static void main(String[] args) {

        Integer[] nums = {1,3,3,7,7,4,4,8,3,5,3,4,6,1,8,3,9};

        Integer[] result = removeDuplicateInUnsortedArray(nums);

        System.out.println(Arrays.toString(result));
    }
}
