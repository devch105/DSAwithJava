package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring_P76 {
    static void main() {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Answer : "+MinimumWindowSubstring(s,t));
    }

    public static String MinimumWindowSubstring(String s, String t) {
        int left = 0;
        int right = 0;
        int count=t.length();
        int minLen = Integer.MAX_VALUE;
        // important  to mark start of substring
        int strt=0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // Fill map for T
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        while(right<s.length()) {
            char c1 = s.charAt(right);
            // if Map containsKey decrease count-- and decrease map frequency --;
             if(map.containsKey(c1)){
                 if(map.get(c1)>0){
                     count--;
                 }
                 map.put(c1, map.get(c1)-1);
             }
            while (count == 0) {


                // check Min len and mark start pointer to left
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    strt=left;
                }

                // handling shrinking
                char c2 = s.charAt(left);
                // check if map have key : increase frequency and if freq >0 : count ++;
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        count++;
                    }
                }
                left++;
            }
            right++;
        }

        // return the "start of substring with minLen"
        return minLen == Integer.MAX_VALUE ? "" : s.substring(strt,strt+minLen);
    }
}
