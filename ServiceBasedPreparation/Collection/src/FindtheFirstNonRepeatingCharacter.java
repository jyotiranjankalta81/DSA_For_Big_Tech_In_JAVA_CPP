import java.util.Locale;

public class FindtheFirstNonRepeatingCharacter {



    public static char findFirstNonRepeting(String str){

        int [] chars = new int[26];



        for(char ch:str.toLowerCase().toCharArray()){
            int diff = ch-'a';
            chars[diff]++;
        }

        for(char ch:str.toLowerCase(Locale.ROOT).toCharArray()){
            int diff = ch-'a';
            if(chars[diff]<2){
                return ch;
            }
        }
        return 0;
    }

    public static void main (String[] args){


        System.out.println(
                findFirstNonRepeting("listen")
        );

        System.out.println(
                findFirstNonRepeting("hello")
        );
    }
}
