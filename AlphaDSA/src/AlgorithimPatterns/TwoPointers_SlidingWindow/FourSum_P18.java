package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FourSum_P18 {
    static void main() {
        int [] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println("Answer : "+fourSum(nums,target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // duplicates ko skip karo
             if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length; j++){
                // duplicates ko skip karo
                if(j>i+1 && nums[j]==nums[j-1])continue;

                result.addAll(twoSum(nums,target,i,j,j+1,nums.length-1));
            }
        }
        return result;
    }
    public  static List<List<Integer>> twoSum(int[] nums, int target,int i, int j, int left, int right) {
        List<List<Integer>> result = new ArrayList<>();

        while (left < right) {
            long sum = (long) nums[left] + nums[right] +nums[i] + nums[j];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;

                left++;
                right--;
            }
        }

        return result;
    }

}
