package algorithimPatterns.SlidingWindow;

public class MaximumConsecutiveOnes_P1004 {

    static void main() {

        int[] nums = {
                0,0,1,1,0,0,1,1,1,
                0,1,1,0,0,0,1,1,1,1
        };

        int k = 3;

        System.out.println(
                "Maximum Consecutive Ones : "
                        + longestOnes(nums, k)
        );
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int maxLen = 0;

        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {

            // include right element
            if (nums[right] == 0) {
                zeroCount++;
            }

            // invalid window
            while (zeroCount > k) {

                // remove left element
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // valid window length
            maxLen = Math.max(
                    maxLen,
                    right - left + 1
            );
        }

        return maxLen;
    }
}