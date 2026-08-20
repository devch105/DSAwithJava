package DP;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        int dp[][] = new int[val.length + 1][W + 1];

        System.out.println("Answer : " + solve(val, wt, W, dp));

    }

    public static int solve(int nums[], int wt[], int cap, int dp[][]) {
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                int v = nums[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    int ans1 = v + dp[i][j - w];
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][cap];
    }
}
