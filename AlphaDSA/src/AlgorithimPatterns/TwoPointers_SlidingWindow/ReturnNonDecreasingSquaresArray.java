package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.Arrays;

public class ReturnNonDecreasingSquaresArray {
    public static int[] non_decreasingSquares(int arr[]) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans[] = new int[n];
        int k = n - 1; // fill from the end

        while (left <= right) {
            int lefter = arr[left] * arr[left];
            int righter = arr[right] * arr[right];

            if (lefter > righter) {
                ans[k] = lefter;
                left++;
            } else {
                ans[k] = righter;
                right--;
            }
            k--; // move fill position backward
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-10, -3, -2, 1, 4, 5};
        int result[] = non_decreasingSquares(arr);
        System.out.println(Arrays.toString(result));
    }
}
