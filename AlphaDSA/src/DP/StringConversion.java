package DP;

public class StringConversion {
    public static void main(String[] args) {
        String s1 = "abcedf";
        String s2 = "aceg";

        int lcs = lcs(s1, s2);
        int delete = s1.length() - lcs;
        int insert = s2.length() - lcs;
        System.out.println("Answer : " + (delete + insert));
    }

    public static int lcs(String s, String y) {
        int n = s.length();
        int m = y.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = y.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
}
