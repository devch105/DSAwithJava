package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_494 {

    /***
     * 
     * You are given an integer array nums and an integer target.
     * 
     * You want to build an expression out of nums by adding one of the symbols '+'
     * and '-' before each integer in nums and then concatenate all the integers.
     * 
     * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
     * and concatenate them to build the expression "+2-1".
     * Return the number of different expressions that you can build, which
     * evaluates to target.
     *
     **/
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println("Answer : " + calculateExpSum(arr, target, 0, 0));

        int sum = Arrays.stream(arr).sum();
        int dp[][] = new int[arr.length + 1][2 * sum + 1];

        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        System.out.println("Answer Memoization :: " + calExpSum(arr, dp, target, 0, 0, sum));

        for (int[] array : dp) {
            System.out.println(Arrays.toString(array));
        }

        Map<String, Integer> map = new HashMap<>();
        System.out.println("Answer using Map : " + calExpMap(arr, target, 0, 0, map));
    }

    public static int calculateExpSum(int nums[], int target, int cSum, int i) {
        if (i == nums.length) {
            if (target == cSum) {
                return 1;
            } else {
                return 0;
            }
        }

        int plus = calculateExpSum(nums, target, cSum + nums[i], i + 1);
        int minus = calculateExpSum(nums, target, cSum - nums[i], i + 1);

        return plus + minus;
    }

    // Recursive +Memoization
    public static int calExpSum(int nums[], int dp[][], int target, int cSum, int i, int sum) {
        if (i == nums.length) {
            if (cSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[i][cSum + sum] != -1) {
            return dp[i][cSum + sum];
        }

        int plus = calExpSum(nums, dp, target, cSum + nums[i], i + 1, sum);
        int minus = calExpSum(nums, dp, target, cSum - nums[i], i + 1, sum);

        dp[i][cSum + sum] = plus + minus;
        return dp[i][cSum + sum];
    }

    public static int calExpMap(int nums[], int target, int cSum, int i, Map<String, Integer> map) {
        if (i == nums.length) {
            if (cSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = i + "_" + cSum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int plus = calExpMap(nums, target, cSum + nums[i], i + 1, map);
        int minus = calExpMap(nums, target, cSum - nums[i], i + 1, map);

        map.put(key, plus + minus);
        return map.get(key);
    }

}
