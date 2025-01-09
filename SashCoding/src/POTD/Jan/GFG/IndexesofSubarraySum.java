package POTD.Jan.GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexesofSubarraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int currSum=0;
        Map<Integer,Integer> mp = new HashMap();
        ArrayList<Integer> ans = new ArrayList();
        mp.put(0, -1);
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(mp.containsKey(currSum-target)){
                ans.add(mp.get(currSum-target)+2);
                ans.add(i+1);
                return ans;
            }
            else {
                mp.put(currSum, i);
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
     int   arr[] = {1, 2, 3, 7, 5};
     int target = 12;
        System.out.println("Answer : "+subarraySum(arr,target));
    }
}
