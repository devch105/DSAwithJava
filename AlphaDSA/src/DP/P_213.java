package DP;

import java.util.Arrays;
import java.util.HashMap;

public class P_213 {
    public static void main(String[] args) {
        int[] arr = { 1 };
        // if (house.length == 1) {
        // System.out.println("Answer : " + house[0]);
        // } else {
        // System.out.println("Answer : " + rob(house));
        // }
        HashMap<Integer, Integer> map = new HashMap<>();
        int z = memo(0, arr.length - 2, arr, map);
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int o = memo(1, arr.length - 1, arr, map1);
        System.out.println();
        Math.max(z, o);
    }

    public static int memo(int i, int x, int arr[], HashMap<Integer, Integer> map) {
        if (i > x) {
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }

        int pick = arr[i] + memo(i + 2, x, arr, map);
        int miss = memo(i + 1, x, arr, map);

        map.put(i, Math.max(pick, miss));
        return map.get(i);
    }

    public static int rob(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int first = solve(0, arr.length - 2, arr, dp);
        Arrays.fill(dp, -1);
        int second = solve(1, arr.length - 1, arr, dp);
        return Math.max(first, second);
    }

    public static int solve(int i, int x, int nums[], int dp[]) {
        if (i > x) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans1 = nums[i] + solve(i + 2, x, nums, dp);
        int ans2 = solve(i + 1, x, nums, dp);

        dp[i] = Math.max(ans1, ans2);
        return dp[i];
    }
}
