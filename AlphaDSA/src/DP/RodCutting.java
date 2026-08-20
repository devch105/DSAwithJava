package DP;

public class RodCutting {
    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

        int rodlenth = 8;

        System.out.println("Answer : " + maxPriceCutting(length, price, rodlenth));
    }

    public static int maxPriceCutting(int[] len, int price[], int rodlen) {
        int n = price.length;
        int dp[][] = new int[n + 1][rodlen + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodlen + 1; j++) {
                int v = price[i - 1];
                int w = len[i - 1];

                if (w <= j) {

                    int ans1 = v + dp[i][j - w];
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][rodlen];
    }

}
