package DP;

import java.util.Arrays;

public class MInimumPationing {

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        int midDiff = 1;
        System.out.println("Answer : "+partitionDiff(arr, midDiff));
    }

    public static int partitionDiff(int arr[], int minDiff){
        int total = 0;
        for (int x : arr) {
           total += x;
        }
        int target = total / 2;
        int dp[][] = new int[arr.length + 1][target + 1];
         for (int y[] : dp) {
            Arrays.fill(y, -1);
        }
        int diff = Math.abs(total-target - minimumPartitioning(arr, target, dp, 0));
        return diff;
    }

    public static int minimumPartitioning(int arr[], int target, int dp[][], int i) {
        if (target == 0) {
            return 0;
        }
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        if (arr[i] <= target) {
            int pick = arr[i] + minimumPartitioning(arr, target - arr[i], dp, i + 1);
            int leave = minimumPartitioning(arr, target, dp, i + 1);

            return dp[i][target] = Math.max(pick, leave);
        } else {
            return dp[i][target] = minimumPartitioning(arr, target, dp, i + 1);
        }
    }
}
