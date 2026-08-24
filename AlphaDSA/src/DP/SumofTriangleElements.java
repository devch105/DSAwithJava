package DP;

import java.util.Arrays;
import java.util.Scanner;

public class SumofTriangleElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            int dp[][] = new int[n + 1][n + 1];
            for (int arr[] : dp) {
                Arrays.fill(arr, -1);
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= j; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            for (int p[] : matrix) {
                System.out.println(Arrays.toString(p));
            }
            System.out.println("Answer : " + findMax(matrix, 0, 0));
            System.out.println("Memo : " + memo(matrix, 0, 0, dp));
            System.out.println("Tab : " + tab(matrix));

        }
    }

    public static int findMax(int matrix[][], int i, int j) {
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        int down = findMax(matrix, i + 1, j);
        int diagonal = findMax(matrix, i + 1, j + 1);

        return matrix[i][j] + Math.max(down, diagonal);
    }

    public static int memo(int matrix[][], int i, int j, int dp[][]) {
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = memo(matrix, i + 1, j, dp);
        int diagonal = memo(matrix, i + 1, j + 1, dp);

        dp[i][j] = matrix[i][j] + Math.max(down, diagonal);
        return dp[i][j];
    }

    public static int tab(int matrix[][]) {
        int n = matrix.length;

        int dp[][] = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = matrix[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
