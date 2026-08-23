package DP;

import java.util.Arrays;

public class P_213 {
    public static void main(String[] args) {
        int[] house = { 1 };
        if (house.length == 1) {
            System.out.println("Answer : " + house[0]);
        } else {
            System.out.println("Answer : " + rob(house));
        }
    }

    public static int rob(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int first = solve(0, arr.length - 2, arr, dp);
        Arrays.fill(dp, -1);
        int second = solve(1, arr.length - 1, arr, dp);
        return Math.max(first, second);
    }

    public static int solve(int i, int x, int nums[], int dp[]) {
        if (i > x) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans1 = nums[i] + solve(i + 2, x, nums, dp);
        int ans2 = solve(i + 1, x, nums, dp);

        dp[i] = Math.max(ans1, ans2);
        return dp[i];
    }
}
