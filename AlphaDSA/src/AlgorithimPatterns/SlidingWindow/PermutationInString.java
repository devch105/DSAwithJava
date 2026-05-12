package AlgorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class PermutationInString {
    static void main() {

       String s1 = "ab", s2 = "eidbaooo";
        System.out.println("Permutation Exist : "+checkInclusion(s1,s2));
    }


    public  static boolean checkInclusion(String s1, String s2) {
        int count = s1.length();

        int left =0,right = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        // fill s1 for frequency count :
        for(int i=0; i<s1.length(); i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }


        // right pointer to iterate over string s2
        while(right<s2.length()){
            char c1 = s2.charAt(right);
            if(map.containsKey(c1)){ // check if char is in map
                if(map.get(c1)>0){   // check if frq>0
                    count--;         // decrement count -- as need of character decrease
                }
                map.put(c1,map.get(c1)-1);  // character not present  put(ch, -1)
            }

            // maintaining window string for permutation string length;
            if(right-left+1 > s1.length()){  // if len goes above need
                char c2 = s2.charAt(left);   // take c2 charAt(left)
                if(map.containsKey(c2)){            // increase its frequency
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2)>0){  // if frequnency goes above
                        count++;       // increase count as it will tell window exceed limits here
                    }
                }
                left++;
            }
            if(count==0){               // here window  we are making sure window stays in limit before checking count  it means if a substring has same frequency as s1 exist then count will definitely become = 0
                return true;
            }
            right++;
        }

        return false;
    }
}
