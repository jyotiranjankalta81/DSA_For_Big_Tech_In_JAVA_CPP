public class stringAnagrams {


    public static boolean isAnagram(String str1,String str2){

        int [] chars = new int[26];

        if (str1.length() != str2.length()) {
            return false;
        }

        for(char ch:str1.toLowerCase().toCharArray()){
            int diff = ch-'a';
            chars[diff]++;
        }
        for(char ch:str2.toLowerCase().toCharArray()){
            int diff = ch-'a';
            chars[diff]--;

            if(chars[diff]<0){
                return false;
            }
        }
        return true;


    }

    public static void main (String[] args){


        System.out.println(
                isAnagram("listen", "silent")
        );

        System.out.println(
                isAnagram("hello", "world")
        );
    }
}
