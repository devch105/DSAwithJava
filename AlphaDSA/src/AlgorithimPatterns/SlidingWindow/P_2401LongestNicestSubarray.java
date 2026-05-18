package AlgorithimPatterns.SlidingWindow;

public class P_2401LongestNicestSubarray {
    public static void main(String[] args) {
      System.out.println("Answer : "+new P_2401LongestNicestSubarray().longestNiceSubarray(new int[]{1,3,8,48,10}));  
    }

     public int longestNiceSubarray(int[] nums) {
        int left=0;
        int right=1;
        int count=0;
        int item=nums[0];
        while(right<nums.length){
            if((item & nums[right])==0){
                count++;
            }else{
                left++;
                item=nums[left];
                right=left+1;
            }
            right++;
        }
        return count;
    }
}
