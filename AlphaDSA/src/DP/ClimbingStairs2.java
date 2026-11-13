package DP;

import java.util.Arrays;

public class ClimbingStairs2 {

    public static void main(String args[]) {

        int arr[] = {1, 2, 3, 4 };
        int n = 4;

        System.out.println("Answer: " + climbStairs(n, arr));
    }

    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return memo(0, n, dp, costs);
    }

    public static int memo(int i, int n, int dp[], int costs[]) {
        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = 1; k < 4; k++) { // use counter for loop to jump 1,2,3 steps
            int j = i + k; // j is the next step after jumping k steps from i
            if (j <= n) {

                int exp = costs[j - 1] + k * k; // use j-1 because costs array is 0-indexed and we want the cost of the
                                                // step we are jumping to
                int newCost = memo(j, n, dp, costs);
                minCost = Math.min(minCost, newCost + exp);

            }
        }
        return dp[i] = minCost;
    }

    // public static int memo(int i, int n, int[] dp, int[] cost) {

    // if (i == n) {
    // return 0;
    // }

    // if (dp[i] != -1) {
    // return dp[i];
    // }

    // int minCost = Integer.MAX_VALUE;

    // // Jump 1
    // int j = i + 1;
    // if (j <= n) {
    // int exp = cost[j - 1] + (j - i) * (j - i);
    // int step1 = memo(j, n, dp, cost);
    // minCost = Math.min(minCost, exp + step1);
    // }

    // // Jump 2
    // j = i + 2;
    // if (j <= n) {
    // int exp = cost[j - 1] + (j - i) * (j - i);
    // int step2 = memo(j, n, dp, cost);
    // minCost = Math.min(minCost, exp + step2);
    // }

    // // Jump 3
    // j = i + 3;
    // if (j <= n) {
    // int exp = cost[j - 1] + (j - i) * (j - i);
    // int step3 = memo(j, n, dp, cost);
    // minCost = Math.min(minCost, exp + step3);
    // }

    // return dp[i] = minCost;
    // }

}