package POTD.Jan.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class P_1408 {

    public static List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0;i < n;i++) {

            for (int j = 0;j < n;j++) {
                if (i == j || words[i].length() > words[j].length()) continue;

                if (isSubstring( words[i], words[j] )) {
                    res.add(words[i]);
                    break;
                }
            }

        }

        return res;
    }


    public static boolean isSubstring(String sub, String word) {
        int n = word.length();
        int m = sub.length();
        for (int j = 0; j< n; j++) {
            boolean isMatch = true;
            int k=j;
            int i=0;
            while(i<m){
                if (k >= word.length() || word.charAt(k) != sub.charAt(i)) {
                    isMatch = false;
                    break;
                }
                k++;
                i++;
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       String [] words = {"mass","as","hero","superhero"};
        System.out.println("Answer : "+stringMatching(words));
    }
}
