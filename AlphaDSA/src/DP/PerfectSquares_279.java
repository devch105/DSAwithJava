package DP;

import java.util.Arrays;

public class PerfectSquares_279 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println("Answer : " + perfectSquareCountSum(n));
    }

    public static int perfectSquareCountSum(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {

            int result = 1 + helper(n - i * i, dp);

            minCount = Math.min(minCount, result);
            
        }
        return dp[n]=minCount;
    }
}
