package algorithimPatterns.SlidingWindow;

public class P_1493_LongestSubarrayof1s {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println("Longest Subarray of 1s : "+longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
       int left = 0 , right =0 , count = 0 , maxLen = 0;
       while(right<nums.length){
        if(nums[right]==0)count++;

        while(count>1){
            if(nums[left]==0)count--;
            left++;
        }
        maxLen = Math.max(maxLen, right - left);
        right++;
       }
       return maxLen;
    }
}
