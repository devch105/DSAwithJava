package DP;

import java.util.Arrays;

public class P_198 {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1 };
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);

        int res = solve(0, arr, dp);
        System.out.println("Result : " + res);
    }

    public static int solve(int i, int arr[], int dp[]) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = arr[i] + solve(i + 2, arr, dp);
        int leave = solve(i + 1, arr, dp);

        dp[i] = Math.max(leave, rob);

        return dp[i];
    }
}
