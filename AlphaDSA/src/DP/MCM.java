package DP;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        System.out.println("Answer : " + recur(arr, 1, arr.length - 1));
        int dp[][] = new int[arr.length][arr.length];
        for (int x[] : dp) {
            Arrays.fill(x, -1);
        }
        System.out.println("Memo : " + memo(arr, 1, arr.length - 1, dp));
        for (int r[] : dp) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println("-------------------------------");
        System.out.println("Tabulation Approach : " + tab(arr));
    }

    public static int recur(int arr[], int i, int j) {
        System.out.println("(" + i + "," + j + ")");
        if (i == j) {
            System.out.println("(" + i + "=" + j + ")");
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            System.out.println("(" + i + "," + j + "," + k + ")");
            int cost1 = recur(arr, i, k);
            int cost2 = recur(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int memo(int arr[], int i, int j, int dp[][]) {
        System.out.println("(" + i + "," + j + ")");
        if (i == j) {
            System.out.println("(" + i + "=" + j + ")");
            return 0;
        }
        if (dp[i][j] != -1) {
            System.out.println("(" + i + "," + j + ") = " + dp[i][j]);
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            System.out.println("(" + i + "," + j + "," + k + ")");
            int cost1 = memo(arr, i, k, dp);
            int cost2 = memo(arr, k + 1, j, dp);

            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        dp[i][j] = ans;
        System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
        return dp[i][j];
    }

    public static int tab(int arr[]) {

        /**
         * 1. Table dp[n][n]
         * 2. Meaning + Initialization
         * 3. Fill (Bottom-up) Manner
         */
        int dp[][] = new int[arr.length][arr.length];
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // bottom up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        for (int x[] : dp) {
            System.out.println(Arrays.toString(x));
        }
        return dp[1][n - 1];
    }
}
