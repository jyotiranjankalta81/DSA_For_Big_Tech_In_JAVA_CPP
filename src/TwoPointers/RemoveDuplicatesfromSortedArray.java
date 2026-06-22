package TwoPointers;

public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicate(int arr[]){
        int slow=0;
        if(arr.length==0){
            return 0;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] != arr[slow]){
                slow++;
                arr[slow]=arr[i];
            }
        }
        return slow+1;
    }
}
