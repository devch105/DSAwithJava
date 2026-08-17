package DP;

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        int[] heights = { 20, 30, 40, 20 };
        int n = heights.length;

        System.out.println("MinCost : " + forgJumpCost(n - 1, heights));
        int dp [] = new int[n];

        System.out.println("MinCost Memoization : "+solve(n-1, heights, dp));
        System.out.println("MinCost with Tabulation : "+solveTab(n, heights));
    }

    public static int forgJumpCost(int n, int[] heights) {
        if (n == 0) {
            System.out.println("0");
            return 0;
        }
        int first = forgJumpCost(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int second = Integer.MAX_VALUE;

        System.out.println("1st : " + first + " & 2nd : " + second);

        if (n > 1) {
            second = forgJumpCost(n - 2, heights) + Math.abs(heights[n - 2] - heights[n]);
            System.out.println("2nd : " + second);
        }

        System.out.println("Min(1st and 2nd)");
        return Math.min(first, second);
    }
    
    
    public static int solve(int n, int heights[], int dp[]) {
        if(n==0)return 0;

        if(dp[n]!=0){
            return dp[n];
        }

        int firstJump = solve(n-1, heights, dp) + Math.abs(heights[n]-heights[n-1]);
        int second = Integer.MAX_VALUE;

        if(n>1){
            second = solve(n-2, heights, dp)+ Math.abs(heights[n]-heights[n-2]);
        }

        return dp[n]=Math.min(firstJump, second);
    }

    public static int solveTab(int n , int heights[]){
        int dp[] = new int[heights.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<n; i++){
            int first =  dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1){
                second = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }

            dp[i]=Math.min(first, second);
        }

        return dp[n-1];
    }
}
