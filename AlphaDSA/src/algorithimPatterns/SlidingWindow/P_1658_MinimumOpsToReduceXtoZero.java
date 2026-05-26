package  algorithimPatterns.SlidingWindow;
import java.util.HashMap;
public class P_1658_MinimumOpsToReduceXtoZero {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
    public static int minOperations(int[] nums, int x) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int sum=0;
      map.put(0,-1);
      for(int i=0; i<nums.length; i++){
          sum+=nums[i];
          map.put(sum,i);
      }
      if(sum<x)return -1;
      int remainingSum = sum-x;
      sum=0;
      
      int maxLength = Integer.MIN_VALUE;
      
      for(int i=0; i<nums.length; i++){
        sum += nums[i];
        int findSum  = sum-remainingSum;
        if(map.containsKey(findSum)){
            int index = map.get(findSum);
            maxLength = Math.max(maxLength,i-index);
        }
      }

      return maxLength==Integer.MIN_VALUE?-1:nums.length-maxLength;

    }
}
