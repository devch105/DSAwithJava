package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_322 {
    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        int amount = 27;
        System.out.println("Answer : " + coinChange(coins, amount));

        Map<String, Integer> map = new HashMap<>();
        System.out.println("Answer Just checking : " + coinChangeMemo(coins, map, amount, 0));
        System.out.println("Map : "+map);
    }

    public static int coinChangeMemo(int coins[], Map<String, Integer> map, int amount, int i) {
        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length) {

            return Integer.MAX_VALUE - 1;
        }
        String key = i + "_" + amount;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (coins[i] <= amount) {

            int ans1 = 1 + coinChangeMemo(coins, map, amount - coins[i], i);
            int ans2 = coinChangeMemo(coins, map, amount, i + 1);

            int result = Math.min(ans1, ans2);
            map.put(key, result);
            return map.get(key);
        } else {
            int exclude = coinChangeMemo(coins, map, amount, i + 1);
            map.put(key, exclude);
            return map.get(key);
        }
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
