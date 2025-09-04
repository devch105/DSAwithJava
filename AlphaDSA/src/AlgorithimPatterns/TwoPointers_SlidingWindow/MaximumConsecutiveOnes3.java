package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class MaximumConsecutiveOnes3 {
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(MaxConsecutiveOnes(arr, 2)); // Output: 6
    }

    public static int MaxConsecutiveOnes(int arr[], int k) {
        int left = 0, maxLen = 0, zeros = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeros++;
            }
            // If zeros exceed k, shrink window from the left
            while (zeros > k) {
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }
            // Update maxLen after ensuring zeros <= k
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
