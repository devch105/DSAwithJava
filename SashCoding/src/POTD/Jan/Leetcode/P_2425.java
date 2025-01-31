package POTD.Jan.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class P_2425 {
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;

        int res=0;
        if(n%2!=0){
            for(int num:nums2){
                res^=num;
            }
        }
        int m=nums2.length;
        if(m%2!=0){
            for(int num: nums1){
                res^=num;
            }
        }
        return res;

    }

    public static void main(String[] args) {
     int  []  nums1 = {2,1,3}, nums2 = {10,2,5,0};
        System.out.println("Answer :"+xorAllNums(nums1,nums2));
    }
}
