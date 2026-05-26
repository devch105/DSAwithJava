package algorithimPatterns.TwoPointers;

import java.util.Arrays;

public class RotateArray_P189 {
    static void main(){
        int arr [] ={1,2,3,4,5,6,7,8};
        int k=3;
        rotate(arr,k);
        System.out.println("Answer : "+ Arrays.toString(arr));
    }
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        if(k == 0){return ;}
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public static void reverse(int[]nums, int left , int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
