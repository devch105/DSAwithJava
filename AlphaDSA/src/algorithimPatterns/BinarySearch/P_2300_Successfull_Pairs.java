package algorithimPatterns.BinarySearch;

import java.util.Arrays;

public class P_2300_Successfull_Pairs {
    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 8 };
        int[] nums2 = { 2, 6, 5 };
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs(nums1, nums2, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        Arrays.sort(potions);
        int maxPotion = potions[n - 1];
        int ans[] = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            long minPotion = (success + spells[i] - 1) / spells[i];

            if (minPotion > maxPotion) {
                ans[i] = 0;
                continue;
            }

            int index = lowerBound(potions, 0, n - 1, minPotion);

            int count = n - index;

            ans[i] = count;
        }

        return ans;
    }

    public static int lowerBound(int arr[], int left, int right, long target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
