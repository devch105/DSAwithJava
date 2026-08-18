package DP;

import java.util.Arrays;

public class P_746 {
    public static void main(String[] args) {
        int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

        System.out.println("Min cost : " + minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));

    }

    public static int solve(int i, int cost[], int[] dp) {
        if (i >= cost.length)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int firstJump = solve(i + 1, cost, dp);
        int secondJump = solve(i + 2, cost, dp);

        dp[i] = cost[i] + Math.min(firstJump, secondJump);
        return dp[i];
    }
}
