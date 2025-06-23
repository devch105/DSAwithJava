package POTD.Feb.Leetcode;

public class P_1752 {
    public static boolean check(int[] nums) {
        int peak=0;
        int n=nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>nums[(i+1)%n]){
                peak++;
            }
        }
        return peak<=1;
    }


    public static void main(String[] args) {
      int []  nums = {2,1,3,4};
        System.out.println("Answer : "+check(nums));
    }
}
