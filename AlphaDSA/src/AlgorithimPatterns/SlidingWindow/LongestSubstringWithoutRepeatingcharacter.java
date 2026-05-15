package AlgorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingcharacter {
    public static void main(String[] args) {
        System.out.println(LongestSubstringwithoutRepeatingcharacter("abcabcbb"));  // Output: 3
        System.out.println(LongestSubstringwithoutRepeatingcharacter("bbbbb"));     // Output: 1
        System.out.println(LongestSubstringwithoutRepeatingcharacter("pwwkew"));    // Output: 3

    }
    public static int LongestSubstringwithoutRepeatingcharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >=left){
                left= map.get(s.charAt(i))+1;

            }
                map.put(s.charAt(i), i);
                max = Math.max(max, i-left+1);

        }
        return max;
    }






//    public static  int LongestSubstringwithoutRepeatingCharacter(String s){
//        int left=0,maxLen=0,n=s.length();
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int right=0; right<n; right++){
//            char ch=s.charAt(right);
//            if(map.containsKey(ch) && map.get(ch)>=left){
//                left=map.get(ch)+1;
//            }
//            map.put(ch,right);
//            maxLen= Math.max(maxLen,right-left+1);
//        }
//return maxLen;
//    }
}
