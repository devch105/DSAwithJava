package algorithimPatterns.HashMap_HashSet;

import java.util.HashMap;

public class Valid_Anagram {
  
   public static void main(String[] args) {
     String a ="abc";
     String b ="cab";

     System.out.println("answer : "+isAnagram(a,b));
   }
     public static boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            map.put(s1,map.getOrDefault(s1,0)+1);
            map.put(t1,map.getOrDefault(t1,0)-1);
        }

       for(int value : map.values()){
        if(value!=0){
            return false;
        }
       }
        return true;
    }
}
