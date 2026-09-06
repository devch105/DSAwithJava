package algorithimPatterns.TwoPointers;

public class MinimumSizeSubArraySum_P209 {

    public static void main(String[] args) {

        int arr[] = {1,1,1,1,1,1,1};
        int target = 11;

        System.out.println(
                "Minimum subarray length : "
                        + minSubArrayLen(target, arr)
        );
    }

   public static  int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int left=0;
        int min = Integer.MAX_VALUE;
        int right =0;

        while(right < nums.length){

            sum+=nums[right];


            while(sum >= target){
               min = Math.min(min,right-left+1);

               sum-=nums[left];
               left++;
            }
            right++;
        }   
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}