package DP;

import java.util.Arrays;

public class P_416 {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 11, 5 };
        System.out.println("Answer : " + canPartition(arr));
        System.out.println("Answer Tab : " + Tab(arr, 11));

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
        boolean result = solveMemo(nums, 0, target, dp);

        for (int i[] : dp) {
            System.out.println(Arrays.toString(i));
        }
        return result;
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

    public static boolean Tab(int nums[], int target) {
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][target + 1];

        // if target = 0 always true
        for (int i = 0; i <=n; i++) {
            dp[i][0] = true;
        }
        // i == n -> no element left
        // dp[n][target] remains false for target>0

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < target + 1; j++) {

                boolean notTake = dp[i + 1][j];

                boolean take = false;
                if (nums[i] <= target) {
                    take = dp[i + 1][target - nums[i]];
                }

                dp[i][j] = take || notTake;

            }
        }
        return dp[0][target];
    }
}
