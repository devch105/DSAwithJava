package POTD.Jan.GFG;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayK {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int currSum=0, ans=0;
        Map<Integer,Integer> mp = new HashMap();
        mp.put(0, -1);
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(mp.containsKey(currSum-k)){
                ans=Math.max(ans, i-mp.get(currSum-k));
            }
            mp.putIfAbsent(currSum, i);
        }
        return ans;
    }
    public static void main(String[] args) {
         int  arr[] = {10, 5, 2, 7, 1, -10};
         int k = 15;
    }
}
