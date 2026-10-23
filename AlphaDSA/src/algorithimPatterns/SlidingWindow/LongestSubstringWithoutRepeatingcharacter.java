package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingcharacter {
    public static void main(String[] args) {
        System.out.println(LongestSubstringwithoutRepeatingcharacter("abcabcbb"));  // Output: 3
        System.out.println(LongestSubstringwithoutRepeatingcharacter("bbbbb"));     // Output: 1
        System.out.println(LongestSubstringwithoutRepeatingcharacter("pwwkew"));    // Output: 3

    }
    public static int LongestSubstringwithoutRepeatingcharacter(String s) {
       int left =0 , right =0, max=-1;
       HashMap<Character, Integer> map = new HashMap<>();
       while(right<s.length()){
        char ch = s.charAt(right);
        if(map.containsKey(ch) && map.get(ch)>=left){
            left = map.get(ch)+1;

        }
        map.put(ch,right);
        max = Math.max(max, right-left+1);
        right++;
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
