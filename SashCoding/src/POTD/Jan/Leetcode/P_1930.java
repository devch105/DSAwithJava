package POTD.Jan.Leetcode;

import java.util.HashSet;

public class P_1930 {
    public static int countPalindromicSubsequence(String s) {
        // find unique char
        int count=0;
        HashSet<Character>hs=new HashSet<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            hs.add(s.charAt(i));
        }
        for (char ch:hs) {
            int first = -1;
            int last = -1;

            for (int i = 0; i < n; i++) {
                if (ch == s.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }
            if (first == last) continue;
            HashSet<Character> hs1 = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                hs1.add(s.charAt(i));
            }
            count += hs1.size();
        }
        return count;
    }
    public static void main(String[] args) {
        String s="aabca";
        System.out.println("Answer :: "+countPalindromicSubsequence(s));
    }
}
