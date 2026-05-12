package AlgorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    static void main() {
        String s = "AABABBA"; int k = 1;
       // Output: 4

        System.out.println("Answer : "+CharacterReplacement(s, k));
    }

    public  static int  CharacterReplacement(String S, int K){
        int left=0,right=0,maxLen=0,maxFreq=0;
        HashMap<Character,Integer> map=new HashMap<>();

        // right pointer interate over string  find maxFreq in HashMap
        while(right<S.length()){
            char c1 = S.charAt(right);
            map.put(c1,map.getOrDefault(c1,0)+1);
            maxFreq=Math.max(maxFreq,map.get(c1));


            while((right-left+1)-maxFreq>K){ // condition  if window-Len - MaxFreq > k  --> Shrink the Window
                char c2 = S.charAt(left);
                map.put(c2,map.getOrDefault(c2,0)-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
