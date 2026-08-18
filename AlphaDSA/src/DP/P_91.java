package DP;

import java.util.Arrays;

public class P_91 {

    public static void main(String[] args) {

        String s = "226";
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        System.out.println("Answer : " + solve(0, s, dp));

    }

    public static int solve(int i, String s, int dp[]) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int first = solve(i + 1, s, dp);
        int second = 0;
        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
                second = solve(i + 2, s, dp);
            }
        }

        int result = first + second;
        dp[i] = result;
        return dp[i];
    }
}
