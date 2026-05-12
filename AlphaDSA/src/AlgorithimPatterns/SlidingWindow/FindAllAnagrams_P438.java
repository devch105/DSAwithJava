package AlgorithimPatterns.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams_P438 {
    static void main() {
        String s = "cbaebabacd", p = "abc";
        System.out.println("Start index of Anagrams : "+findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int left=0;
        int right=0;
        int count= p.length();
       // int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        // fill up Map
        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }

        // main Algo

        while(right < s.length()){
            char c1 = s.charAt(right);
            if(map.containsKey(c1)){
                if(map.get(c1)>0){
                    count--;
                }
                map.put(c1,map.get(c1)-1);
            }

            if((right-left+1)>p.length()){
                char c2 = s.charAt(left);
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2)>0){
                        count++;
                    }
                }
                left++;
            }
            if(count == 0){
                list.add(left);
            }
            right++;
        }
        return list;
    }
}
