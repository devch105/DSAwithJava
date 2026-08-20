package DP;

import java.util.Arrays;

public class P_322 {
    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        int amount = 27;
        System.out.println("Answer : " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE - 1;
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = INF;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j <= amount; j++) {

                int v = coins[i - 1];

                if (v <= j) {
                    int ans1 = 1 + dp[i][j - v];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.min(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int arr[] : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return (dp[coins.length][amount] == INF)
                ? -1
                : dp[coins.length][amount];
    }

}
