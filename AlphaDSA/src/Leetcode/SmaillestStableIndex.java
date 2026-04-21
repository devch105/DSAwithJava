package Leetcode;

import java.util.Arrays;

public class SmaillestStableIndex {
    static void main() {
        int arr [] ={5,0,1,4};
        int k = 3;
        System.out.println("Answer : "+firstStableIndex(arr,k));
    }

    public static int firstStableIndex(int[] nums, int k) {


        // create prefix max array
        int[] prefixmax = new int[nums.length];
        int [] suffixmin = new int[nums.length];

        prefixmax[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            prefixmax[i]= Math.max(prefixmax[i-1],nums[i]);
            System.out.println("Prefix Array = "+ Arrays.toString(prefixmax));
        }


        suffixmin[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--){
            suffixmin[i] =Math.min(suffixmin[i+1],nums[i]);
            System.out.println("Suffix Array : "+Arrays.toString(suffixmin));
        }

        for(int i=0; i<nums.length; i++){
            if(prefixmax[i]-suffixmin[i]<=k){
                return i;
            }
        }

        return -1;
    }


}
