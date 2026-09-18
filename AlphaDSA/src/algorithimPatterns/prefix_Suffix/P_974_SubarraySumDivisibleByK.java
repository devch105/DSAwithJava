package algorithimPatterns.prefix_Suffix;

import java.util.HashMap;

public class P_974_SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println("Answer : " + subArraySumDivisibleByK(nums, k));
    }
    public static int subArraySumDivisibleByK(int[] nums, int k){
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            prefixSum +=nums[i];
             
            int rem = prefixSum % k;
            if(map.containsKey(rem)){
                count +=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
