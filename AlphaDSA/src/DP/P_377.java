package DP;

import java.util.HashMap;
import java.util.Map;

public class P_377 {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 4;
        System.out.println("Answer : " + combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return Memo(nums, target, map);

    }

    public static int Memo(int nums[], int target, Map<Integer, Integer> map) {
        if (target == 0) {
            return 1;
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        int ways = 0;
        for (int num : nums) {
            if (num <= target) {
                ways += Memo(nums, target - num, map);
            }
        }
        map.put(target, ways);
        return ways;
    }

}
