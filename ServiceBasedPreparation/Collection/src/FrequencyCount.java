import java.util.*;

public class FrequencyCount {

    public static int freqCount(int []arr){

    HashMap <Integer,Integer> map = new HashMap<>();
    for(int i = 0; i< arr.length; i++){

        if(map.containsKey(arr[i])){
            map.put(map.getOrDefault(arr[i],0),1);
        }else{
            map.put(arr[i],1);
        }

    }

        // Find the entry with the highest value
        Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(),
                Map.Entry.comparingByValue());

    return maxEntry.getKey();

    }

    public  static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the arr length: ");
        int s = sc.nextInt();
        int [] arr1 = new int[s];

        System.out.println("Enter the list of elements: ");
        for (int i=0;i<s;i++){
            arr1[i]=sc.nextInt();
        }

        System.out.println("this is the highest no in the arr: "+  freqCount(arr1));
    }






}
