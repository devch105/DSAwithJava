package DP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("climbing stairs : " + climbingStairs(n));
        int dp[] = new int[n + 1];
        System.out.println("climbing Stairs Memo : " + climbMemo(n, dp));
        int dptab[] = new int[n + 1];
        System.out.println("climbing Stairs Tab : " + climbTab(n, dptab));
        System.out.println("Iteration Bases Approach : " + climbIter(n));
    }

    public static int climbingStairs(int n) {
        if (n == 0) {
            System.out.println("0 -> " + 1);
            return 1;
        }
        if (n < 0) {
            System.out.println("-0 -> " + 0);
            return 0;
        }
        System.out.println("n -> " + n);
        return climbingStairs(n - 1) + climbingStairs(n - 2);
    }

    public static int climbMemo(int n, int dp[]) {
        if (n == 0) {
            System.out.println("-> 1");
            return 1;
        }
        if (n < 0) {
            System.out.println("-> 0");
            return 0;
        }

        if (dp[n] != 0) {
            System.out.println("dp[n] : " + dp[n]);
            return dp[n];
        }
        dp[n] = climbMemo(n - 1, dp) + climbMemo(n - 2, dp);
        System.out.println("calc(dp[n]) : " + dp[n]);
        return dp[n];
    }

    public static int climbTab(int n, int dp[]) {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[n];
    }

    public static int climbIter(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
