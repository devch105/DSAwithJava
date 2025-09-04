package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingcharacter {
    public static void main(String[] args) {
        System.out.println(LongestSubstringwithoutRepeatingCharacter("abcabcbb"));  // Output: 3
        System.out.println(LongestSubstringwithoutRepeatingCharacter("bbbbb"));     // Output: 1
        System.out.println(LongestSubstringwithoutRepeatingCharacter("pwwkew"));    // Output: 3

    }
    public static  int LongestSubstringwithoutRepeatingCharacter(String s){
        int left=0,maxLen=0,n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>=left){
                left=map.get(ch)+1;
            }
            map.put(ch,right);
            maxLen= Math.max(maxLen,right-left+1);
        }
return maxLen;
    }
}
