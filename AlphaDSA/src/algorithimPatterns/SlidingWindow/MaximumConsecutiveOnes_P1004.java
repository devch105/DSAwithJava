package algorithimPatterns.SlidingWindow;

public class MaximumConsecutiveOnes_P1004 {

    public static void main(String[] args) {

        int[] nums = {
                0, 0, 1, 1, 0, 0, 1, 1, 1,
                0, 1, 1, 0, 0, 0, 1, 1, 1, 1
        };

        int k = 3;

        System.out.println(
                "Maximum Consecutive Ones : "
                        + longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            maxLen = Math.max(i - left + 1, maxLen);
        }
        return maxLen;
    }

}