package algorithimPatterns.TwoPointers;

public class MinimumSizeSubArraySum_P209 {

    public static void main(String[] args) {

        int arr[] = {1,1,1,1,1,1,1};
        int target = 11;

        System.out.println(
                "Minimum subarray length : "
                        + minSubArrayLen(target, arr)
        );
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;

        int minLength = Integer.MAX_VALUE;  // minlen

        for (int right = 0; right < nums.length; right++) {  // right poinnter

            sum += nums[right];  // prefixSum

            while (sum >= target) {  // shrinking window for making len as minimum as possible for the condition

                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];  // remove left from prefix
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}