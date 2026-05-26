package algorithimPatterns.TwoPointers;

import java.util.Arrays;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
int arr[]={0,0,1,1,1,2,2,3,3,4};
        System.out.println("Answer : "+ Arrays.toString(removeDuplicates(arr)));
    }

    public static int [] removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        while(right<nums.length){
            if(nums[right]==nums[left]){
                right++;
            }else {
                left++;
                nums[left]=nums[right];
            }

        }
        while(left<nums.length){
            nums[left]=0;
            left++;
        }
        return nums;
    }

   /* public static int removeDuplicates(int arr[]){
        int i=0;
        int j=1;
        while (j<arr.length){
           if(arr[j]==arr[i]){
               j++;
           }
           else{
               i++;
               arr[i]=arr[j];

           }
        }
    return i+1;
    }*/
}
