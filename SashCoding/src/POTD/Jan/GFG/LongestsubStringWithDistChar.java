package POTD.Jan.GFG;

public class LongestsubStringWithDistChar {
    class Solution {
        public int longestUniqueSubstr(String s) {
            // code here
            int[] freq = new int[26];
            int i=0, j=0, ans=0;
            while(j<s.length()){
                int ch = s.charAt(j)-'a';
                if(freq[ch]>0){
                    ans=Math.max(ans, j-i);
                    while(i<j && s.charAt(i)!=s.charAt(j)){
                        freq[s.charAt(i)-'a']=0;
                        i++;
                    }
                    i++;
                }
                else {
                    freq[ch]++;
                }
                j++;
            }
            ans=Math.max(ans, j-i);
            return ans;
        }
    }
}
