package DP;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int num[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        boolean dp[][] = new boolean[num.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        System.out.println("Answer :" + targetSum(num, target, dp));

        for (boolean arr[] : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static boolean targetSum(int num[], int target, boolean dp[][]) {
        for (int i = 1; i < num.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = num[i - 1];

                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[num.length][target];
    }
}