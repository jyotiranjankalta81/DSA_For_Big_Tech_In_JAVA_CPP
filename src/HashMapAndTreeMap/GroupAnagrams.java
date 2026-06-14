package HashMapAndTreeMap;

import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {

  static boolean IsAnagram(String s,String t){
      Map<Character, Integer> freq = new HashMap<>();

      System.out.println("Enter first string: c"+ freq);
      for(char c : s.toCharArray()) {
          freq.put(c, freq.getOrDefault(c, 0) + 1);
      }
      System.out.println("Enter first string: c1"+ freq);
      for(char c : t.toCharArray()) {
          freq.put(c, freq.getOrDefault(c, 0) - 1);
      }
      System.out.println("Enter first string: c2"+ freq);

      for(int count : freq.values()) {
          if(count != 0)
              return false;
      }

      return true;
  }
  public static void main (String [] args){

//      List<String> groupAnagram = new ArrayList<String>();
      Scanner sc = new Scanner(System.in);
//
//      System.out.print("Enter first string: ");
//      String s1 = sc.nextLine();
//
//      System.out.print("Enter second string: ");
//      String s2 = sc.nextLine();
//
//      if (IsAnagram(s1, s2)) {
//          System.out.println("true");
//      } else {
//          System.out.println("false");
//      }

      List<String> groupAnagram = new ArrayList<>();

      System.out.print("Enter number of words: ");
      int n = sc.nextInt();

      System.out.println("Enter words:");

      for (int i = 0; i < n; i++) {
          groupAnagram.add(sc.next());
      }

      System.out.println(groupAnagram);

      sc.close();
  }

}
