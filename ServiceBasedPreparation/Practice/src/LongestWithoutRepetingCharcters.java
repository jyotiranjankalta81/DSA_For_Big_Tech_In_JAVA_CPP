import java.util.HashMap;

public class LongestWithoutRepetingCharcters {
    public static String LWR (String str){

        int left=0,max=0,maxStart=0;
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                left=i;
            }
            map.put(ch,i);
            int currentMazLength =i- left+1;
            max= Math.max(currentMazLength,max);
            if(currentMazLength>max){
                max=currentMazLength;
                maxStart=left;
            }
        }

        return str.substring(maxStart,maxStart+max);


    }

    public static void main(String[] args) {

        System.out.println(LWR("abcabcbb"));
        System.out.println(LWR("bbbbb"));
        System.out.println(LWR("pwwkew"));
    }
}
