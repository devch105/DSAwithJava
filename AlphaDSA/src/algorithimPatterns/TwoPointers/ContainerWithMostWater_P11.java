package algorithimPatterns.TwoPointers;

public class ContainerWithMostWater_P11 {
    static void main() {
        int arr [] ={1,8,6,2,5,4,8,3,7};
        System.out.println("Area : "+maxArea(arr));
    }
  public static  int maxArea(int[] nums) {
        int maxWater = Integer.MIN_VALUE;
        int left =0 , right = nums.length-1;

        while(left<right){
            int top = Math.min(nums[left],nums[right]);
            int width = right-left;

            int Area = width*top;
            maxWater = Math.max(Area , maxWater);
            
            if(nums[left]<nums[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }

}
