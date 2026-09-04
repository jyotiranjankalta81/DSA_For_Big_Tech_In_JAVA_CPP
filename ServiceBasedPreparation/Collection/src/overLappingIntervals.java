import java.util.*;
public class overLappingIntervals {


    public static int[][] overlapingInterval(int[][] list){
        List<int[]> result = new ArrayList<>();

        // sort intervals based on start value
        Arrays.sort(list,(a,b)->Integer.compare(a[0],b[0]));


        int[] curr = list[0];
        System.out.println("list length  "+list.length);
        for(int i=1;i<list.length;i++){
            int [] next = list[i];

            System.out.println("curr index " + i);

            if(next[0]<= curr[1]){
                curr[1]=Math.max(curr[1],next[1]);
                System.out.println("curr in if " + Arrays.toString(curr));
            }else{
                System.out.println("curr in else " + Arrays.toString(curr));
                result.add(curr);
                curr=next;
            }

//            System.out.println("curr " + Arrays.toString(curr));


        }
        // Add last interval


        for (int[] interval : result) {
        System.out.println("before final "+ Arrays.toString(interval));
        }
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
