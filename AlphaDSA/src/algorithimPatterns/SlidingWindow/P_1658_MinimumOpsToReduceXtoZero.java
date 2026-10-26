package  algorithimPatterns.SlidingWindow;
import java.util.HashMap;
public class P_1658_MinimumOpsToReduceXtoZero {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
    public static  int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int n : nums){
            totalSum +=n;
        }
        int Find = totalSum -x;
        if(Find<0){
            return -1;
        }
        int findLen = FindLen(nums,Find);
        return (findLen == Integer.MIN_VALUE) ? -1 : nums.length-findLen;
    }

    public static  int FindLen(int nums[] , int  x){
        int left =0;
        int right =0;
        int max = Integer.MIN_VALUE;
        int currSum =0;
        while(right < nums.length){
            currSum +=nums[right];

            while(currSum > x && left < nums.length){
                currSum -= nums[left];
                left++;
            }
           if(currSum == x){
             max = Math.max(max, right-left+1);
           }
            right++;
        }
        return max;
    }
}
