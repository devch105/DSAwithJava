package DP;

import java.util.HashMap;
import java.util.Map;

public class P_518 {

    /**
     * 
     * You are given an integer array coins representing coins of different
     * denominations and an integer amount representing a total amount of money.
     * Return the number of combinations that make up that amount. If that amount of
     * money cannot be made up by any combination of the coins, return 0.
     * You may assume that you have an infinite number of each kind of coin.
     * The final answer is guaranteed to fit into a signed 32-bit integer.
     * 
     * Example 1:
     * 
     * Input: amount = 5, coins = [1,2,5]
     * Output: 4
     * Explanation: there are four ways to make up the amount:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     */
    public static void main(String[] args) {
        int[] coins = { 2, 5, 1 };
        int amount = 5;
        Map<String, Integer> map = new HashMap<>();
        // System.out.println("Answer : " + change(amount, coins, map, 0));

        System.out.println("Answer : " + Tab(coins, amount));
    }

    // Memoization Using Map
    public static int change(int amount, int[] coins, Map<String, Integer> map, int i) {
        if (amount == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        String key = i + "_" + amount;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (coins[i] <= amount) {
            int ans1 = change(amount - coins[i], coins, map, i);
            int ans2 = change(amount, coins, map, i + 1);

            map.put(key, ans1 + ans2);
            return map.get(key);
        } else {
            int exclude = change(amount, coins, map, i + 1);
            map.put(key, exclude);
            return map.get(key);
        }

    }
    // Tabulation
    public static int Tab(int coins[], int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {

                int v = coins[i - 1];
                if (v <= j) {
                    int inc = dp[i][j - v];
                    int exc = dp[i - 1][j];
                    dp[i][j] = inc + exc;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

}
