package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]) {
        String s = "aabcdcca";
        int k = 2;
        // Output: 5

        System.out.println("Answer : " + CharacterReplacement(s, k));
    }

    public static int CharacterReplacement(String S, int K) {
       int left =0,right=0,maxFreq=0,maxLen=0;
       HashMap<Character , Integer> map = new HashMap<>();
    
       while(right<S.length()){
          char c = S.charAt(right);  
          map.put(c,map.getOrDefault(c,0)+1);
          maxFreq = Math.max(map.get(c),maxFreq);

          int charToReplace = (right-left+1)-maxFreq;

          if(charToReplace > K){
            char s = S.charAt(left);
            map.put(s,map.getOrDefault(s,0)-1);
           // maxFreq = Math.max(map.get(s),maxFreq);
            left++;
          }
          maxLen = Math.max(maxLen , right-left+1);
          right++;
       }
       return maxLen;
    }
}
