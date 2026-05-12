package AlgorithimPatterns.TwoPointers;

import java.util.Arrays;

public class RangesumQuerries_P33 {

    public static void main(String[] args) {

        RangesumQuerries_P33 obj = new RangesumQuerries_P33();

        int arr[] = {1, 2, 3, 4, 5};

        obj.NumArray(arr);

        System.out.println("Answer : " + Arrays.toString(obj.preSum));

       // System.out.println("Sum Range (1,3) : " + obj.sumRange(1, 3));
    }

    int[] preSum;

    public void NumArray(int[] nums) {

        preSum = new int[nums.length]; // initialize array

        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
    }

//    public int sumRange(int left, int right) {
//
//        if (left == 0) {
//            return preSum[right];
//        }
//
//        return preSum[right] - preSum[left - 1];
//    }
}