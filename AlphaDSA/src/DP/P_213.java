package DP;

import java.util.Arrays;

public class P_213 {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1 };
        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);
        int first = solve(0, arr.length-2, arr, dp);
        Arrays.fill(dp, -1);
        int second = solve(0, arr.length-1, arr, dp);

        int Result = Math.max(first, second);

        System.out.println("Result : "+Result);

      

    }

    public static int solve(int i, int x, int arr[], int dp[]) {
        if (i >= x)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = arr[i] + solve(i + 2, x, arr, dp);
        int leave = solve(i + 1, x, arr, dp);

        dp[i] = Math.max(leave, rob);
        return dp[i];
    }
}
