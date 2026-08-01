package HashMapAndTreeMap.Problems;

import java.util.*;

public class GroupAnagrams {

    public static  List<List<String>> groupStringAnagrams(String[] strs){


        HashMap<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            int[] freq =new int[26];
            for(char c: str.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int count: freq){
                key.append('#');
                key.append(count);
            }
            String k = key.toString();

            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static boolean isAnagram(String s, String t) {

        int[] freq =new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int count: freq){
            key.append('#');
            key.append(count);
        }
        String k1 = key.toString();

        int[] freq1 =new int[26];
        for(char c: t.toCharArray()){
            freq1[c-'a']++;
        }
        StringBuilder key1 = new StringBuilder();
        for(int count: freq1){
            key1.append('#');
            key1.append(count);
        }
        String k2 = key1.toString();

        System.out.println("k1****************** " + k1);
        System.out.println("k2****************** " + k2);

        if(k1.equals(k2)){
            return true;
        }else{
            return  false;
        }

    }
    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        String s1 ="anagram";
        String s2="nagaram";

        System.out.println("check is it a anagram or not " + isAnagram(s1,s2));
    }
}
