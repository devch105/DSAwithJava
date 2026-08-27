package DP;

import java.util.Arrays;

public class MinimumArrayJumps {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };
        System.out.println("Answer : " + minJumps(arr));
    }

    public static int minJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[0];
    }
}
