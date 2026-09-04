import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

    public  static List<String> permutationOfString(String str){

        List<String> result = new ArrayList<>();
        boolean [] read = new boolean[str.length()];


        backtrack(str,new StringBuilder(),read,result);

        return result;

    };

    private static void backtrack(String str,
                                  StringBuilder current,
                                  boolean[] used,
                                  List<String> result){
        // if current length is equal to the string length then return its the base case
        if(current.length()==str.length()){
            result.add(current.toString());
            return;
        }

        //iterate each charcter
        for (int i=0;i<str.length();i++){
            // if already used skip
            if(used[i]){
                continue;
            }
//            if its not use before then make as read
            used[i]=true;
//            now add the char  to the current
            current.append(str.charAt(i));
            //recursevily build the remaining positions
            backtrack(str,current,used,result);

            //Undo / Backtrack
            current.deleteCharAt(current.length()-1);
            used[i]=false;
        }
    }
    public static void main (String [] args ){
        String str = "ABCDE";
        System.out.println("all the permuted string s are " + permutationOfString(str));

    }
}
