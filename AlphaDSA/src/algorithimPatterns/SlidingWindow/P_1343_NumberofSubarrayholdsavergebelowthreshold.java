package algorithimPatterns.SlidingWindow;

public class P_1343_NumberofSubarrayholdsavergebelowthreshold {
public static void main(String[] args) {
    int[] nums = {11,13,17,23,29,31,7,5,2,3};
    int k = 3;
    int threshold = 5;
    
    System.out.println("--> "+numOfSubarrays(nums, k, threshold));
    

}
    public static int numOfSubarrays(int[] nums ,int k, int threshold){
        int count = 0;
        int sum = 0;
        int left=0,right=0;
        while(right<nums.length){
            sum+=nums[right];
            if(right-left+1==k){
                 if(sum/k>=threshold){
                    count++;
                }
            }else if(right-left+1>k){
                sum-=nums[left];
                if(sum/k>=threshold){
                    count++;
                }
                left++;
            }
            right++;
        }
        return count;
    }

}