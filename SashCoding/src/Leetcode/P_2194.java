package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P_2194 {
    public static double minimumAverage(int[] nums) {
        ArrayList<Double> l1 = new ArrayList<>();
        Arrays.sort(nums);

        int strt = 0;
        int end = nums.length - 1;

        while (strt <= end) {
            int min = nums[strt];
            int max = nums[end];
            double avgs = (min + max) / 2.0;
            l1.add(avgs);


            strt++;
            end--;
        }


        return Collections.min(l1);
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println("Answer : " + minimumAverage(arr));
    }
}
