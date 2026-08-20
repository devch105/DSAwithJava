package DP;

import java.util.Arrays;

public class P_416 {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 11, 5 };
        System.out.println("Answer : " + canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        int dp[][] = new int[n + 1][target + 1];
        for (int x[] : dp) {
            Arrays.fill(x, -1);
        }
        // Recursive
        // return isSolve(nums, 0, target);

        // Memoization
        return solveMemo(nums, 0, target, dp);
    }

    // Recursive
    public static boolean isSolve(int nums[], int i, int target) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        boolean take = false;

        if (nums[i] <= target) {
            take = isSolve(nums, i + 1, target - nums[i]);
        }

        boolean notTake = isSolve(nums, i + 1, target);

        return take || notTake;
    }

    // Recursive + Memoization
    public static boolean solveMemo(int nums[], int i, int target, int dp[][]) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean take = false;
        if (nums[i] <= target) {
            take = solveMemo(nums, i + 1, target - nums[i], dp);
        }
        if (take) { // agr possible hora hai subset toh aage mt jaa
            dp[i][target] = 1;
            return true;
        }

        boolean notTake = solveMemo(nums, i + 1, target, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;
        return dp[i][target] == 1;
    }
}
