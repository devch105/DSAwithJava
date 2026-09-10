package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class FruitsIntoBasket_P904 {
    public static void main(String args[]) {

        // int k=2;
        int arr[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };

        System.out.println("total fruits : " + totalFruit(arr));
    }

    public static int totalFruit(int[] nums) {
        int left = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.size() > 2) {
                while (map.size() > 2) {
                    if (map.containsKey(nums[left])) {
                        map.put(nums[left], map.get(nums[left]) - 1);

                        if (map.get(nums[left]) == 0) {
                            map.remove(nums[left]);
                        }
                        left++;
                    }
                }
            }

            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
