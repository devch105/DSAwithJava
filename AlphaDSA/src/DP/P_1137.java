package DP;

import java.util.Arrays;

public class P_1137 {
    public static void main(String[] args) {
        System.out.println("Answer : " + tribonacci(26));
    }

    public static int tribonacci(int n) {
        if (n < 3) {

            return n == 0 ? 0 : 1;
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return solve(n, dp);
    }

    public static int solve(int n, int dp[]) {

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 3, dp) + solve(n - 2, dp) + solve(n - 1, dp);

        return dp[n];
    }
}
