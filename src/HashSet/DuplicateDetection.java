package HashSet;
import java.util.*;

public class DuplicateDetection {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) return true;  // add returns false if already present
        }
        return false;
    }
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer count");
        int count = sc.nextInt();
        System.out.println("enter the list of number");
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<count;i++){
            if(!set.add(sc.nextInt())){
                System.out.println("already present");
            }

        }
        System.out.println("No duplicate value**********" + set);

    }
}


/*
// Pattern 2: Lookup in O(1) — convert array to set first
Set<Integer> numSet = new HashSet<>();
for (int n : nums) numSet.add(n);
if (numSet.contains(target)) { }
 */
