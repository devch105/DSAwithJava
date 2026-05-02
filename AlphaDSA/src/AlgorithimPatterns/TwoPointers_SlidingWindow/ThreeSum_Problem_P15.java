package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static AlgorithimPatterns.TwoPointers_SlidingWindow.TwoSum.twoSum;

public class ThreeSum_Problem_P15 {
    static void main() {
        int arr [] ={ -1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> Finresult = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            Finresult.addAll(twoSum(nums, -nums[i], i + 1, nums.length - 1));
        }

        return Finresult;
    }

    public  static List<List<Integer>> twoSum(int[] nums, int target, int left, int right) {
        List<List<Integer>> result = new ArrayList<>();

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result.add(Arrays.asList(-target,nums[left],nums[right]));

                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;

                left++;
                right--;
            }
        }

        return result;
    }

}
