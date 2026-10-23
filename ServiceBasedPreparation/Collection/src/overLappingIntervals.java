import java.util.*;
public class overLappingIntervals {


    public static int[][] overlapingInterval(int[][] list){
        List<int[]> result = new ArrayList<>();

        // sort intervals based on start value



        Arrays.sort(list,(a,b)->Integer.compare(a[0],b[0]));


        System.out.println("list " + Arrays.deepToString(list));


        //consider first array as current
        int[] curr = list[0];

//        iterate each element in the array
        for(int i=1;i<list.length;i++){
//            consider each elemnt as next
            int [] next = list[i];


            if(next[0]<= curr[1]){
                curr[1]=Math.max(curr[1],next[1]);
            }else{
                result.add(curr);
                curr=next;
            }



        }
        // Add last interval


        result.add(curr);

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {13, 18}
        };

        int[][] result = overlapingInterval(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
