package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde"; // len =n
        String str2 = "ace"; // len =m
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Answer : " + memo(str1, str2, str1.length(), str2.length(), dp));

        System.out.println("Answer : " + Tab(str1, str2));

    }

    public static int longestCommonSubsequence(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        char c1 = str1.charAt(n - 1);
        char c2 = str2.charAt(m - 1);
        if (c1 == c2) {
            return longestCommonSubsequence(str1, str2, n - 1, m - 1) + 1;
        } else {
            int len1 = longestCommonSubsequence(str1, str2, n - 1, m);
            int len2 = longestCommonSubsequence(str1, str2, n, m - 1);
            return Math.max(len1, len2);
        }
    }

    public static int memo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        char c1 = str1.charAt(n - 1);
        char c2 = str2.charAt(m - 1);

        if (c1 == c2) {
            dp[n][m] = 1 + memo(str1, str2, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            int include = memo(str1, str2, n - 1, m, dp);
            int exclude = memo(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(include, exclude);
        }

    }

    public static int Tab(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) { 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int include = dp[i - 1][j];
                    int exclude = dp[i][j - 1];
                    dp[i][j] = Math.max(include, exclude);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
