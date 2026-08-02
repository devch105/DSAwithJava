package POTD.Feb.Leetcode;

public class P_1800 {
    public static int maxAscendingSum(int[] nums) {

        int preSum=nums[0];
        int maxSum=preSum;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                preSum+=nums[i];
                System.out.println(i+"-->"+nums[i]+"-->"+preSum);
            }else{
                preSum=nums[i];
                System.out.println(i+"-->"+nums[i]+"-->"+preSum);
            }
            maxSum=Math.max(maxSum,preSum);
        }
       return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,5,10,50};
        System.out.println("Answer : "+maxAscendingSum(arr));
    }
}
