package DP;

import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcda";
        String s2 = "zbcdf";
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Answer : " + solve(s1, s2, s1.length(), s2.length(), 0));
        // System.out.println("Memo : " + memo(s1, s2, s1.length(), s2.length(), dp));
        System.out.println("Tab : " + tab(s1, s2));
    }

    public static int solve(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0) {
            return count;
        }

        char c1 = s1.charAt(n - 1);
        char c2 = s2.charAt(m - 1);

        if (c1 == c2) {
            count = solve(s1, s2, n - 1, m - 1, count + 1);
        }
        int diff1 = solve(s1, s2, n - 1, m, 0);
        int diff2 = solve(s1, s2, n, m - 1, 0);

        int res = Math.max(count, Math.max(diff1, diff2));
        return res;
    }

    public static int memo(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        char c1 = s1.charAt(n - 1);
        char c2 = s2.charAt(m - 1);

        if (c1 == c2) {
            dp[n][m] = memo(s1, s2, n - 1, m - 1, dp) + 1;
        } else {
            dp[n][m] = 0;
        }

        for (int arr[] : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][m];
    }

    public static int tab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        int maxlen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxlen;
    }

}
