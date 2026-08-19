package DP;

import java.util.Arrays;

public class KnapSack_0_1 {
    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println("Answer : " + knapsack(val, wt, W, val.length));

        int dp[][] = new int[val.length + 1][W + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println("Answer DP Memoization: " + solve(val, wt, dp, W, val.length));

        System.out.println(": Memoization DP Array :");
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("Answer DP Tabulation : " + solveTab(val, wt, W));
    }

    public static int knapsack(int val[], int wt[], int cap, int n) {
        if (cap == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= cap) {
            // include
            int include = val[n - 1] + knapsack(val, wt, cap - wt[n - 1], n - 1);
            int exclude = knapsack(val, wt, cap, n - 1);
            return Math.max(include, exclude);
        } else {
            return knapsack(val, wt, cap, n - 1);
        }
    }

    public static int solve(int val[], int wt[], int dp[][], int cap, int n) {
        if (cap == 0 || n == 0) {
            System.out.println("Its : (" + cap + "," + n + ") --> 0");
            return 0;
        }
        System.out.println("Looking For : (" + cap + "," + n + ") --> ");
        if (dp[n][cap] != -1) {
            System.out.println(" Already : Computed : (" + cap + "," + n + ") --> " + dp[n][cap]);
            return dp[n][cap];
        }

        if (wt[n - 1] <= cap) {
            int newCap = cap - wt[n - 1];
            int ans1 = val[n - 1] + solve(val, wt, dp, newCap, n - 1);
            int ans2 = solve(val, wt, dp, cap, n - 1);

            dp[n][cap] = Math.max(ans1, ans2);
            System.out.println("Computed Result Included : (" + cap + "," + n + ") --> " + dp[n][cap]);
            return dp[n][cap];
        } else {
            dp[n][cap] = solve(val, wt, dp, cap, n - 1);
            System.out.println("Computed Result Excluded : (" + cap + "," + n + ") --> " + dp[n][cap]);
            return dp[n][cap];
        }
    }

    public static int solveTab(int val[], int wt[], int cap) {
        int N = val.length;
        int dp[][] = new int[N + 1][cap + 1];
        // initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    int ans1 = v + dp[i - 1][j - w];
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(" : Tabulation DP Array : ");
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[N][cap];
    }
}
