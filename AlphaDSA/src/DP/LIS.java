package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LIS {
    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println("Memo : " + lis(arr));
    }

    public static int lis(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int temp[] = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(temp);
        int dp[][] = new int[arr.length + 1][temp.length + 1];
        for (int ex[] : dp) {
            Arrays.fill(ex, -1);
        }
        System.out.println("Tab : " + Tab(arr, temp));
        return Memo(arr, temp, arr.length, temp.length, dp);

    }

    public static int Memo(int arr[], int temp[], int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (arr[n - 1] == temp[m - 1]) {
            dp[n][m] = 1 + Memo(arr, temp, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            int ans1 = Memo(arr, temp, n - 1, m, dp);
            int ans2 = Memo(arr, temp, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }

    }

    public static int Tab(int arr[], int temp[]) {
        int dp[][] = new int[arr.length + 1][temp.length + 1];

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < temp.length + 1; j++) {
                if (arr[i - 1] == temp[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[arr.length][temp.length];
    }
}
