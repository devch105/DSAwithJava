package AlgorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class P_1358_numberofSubstringhasOCCURENCEofabc {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(countSubstring(s));
    }
    public static int countSubstring(String s){
        int left =0;
        int right =0;
        int result=0;
         HashMap<Character,Integer> map = new HashMap<>();

        while(right < s.length()){

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch,0)+1);

            while(
                    map.getOrDefault('a',0) > 0 &&
                    map.getOrDefault('b',0) > 0 &&
                    map.getOrDefault('c',0) > 0
            ){

                result += s.length() - right;

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar)-1);

                left++;
            }

            right++;
        }

        return result;
    }

}
