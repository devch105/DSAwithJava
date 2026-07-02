package algorithimPatterns.BinarySearch;

public class P_875_KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = piles[0];
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isPossible(int arr[], int mid, int h) {
        int actualTime = 0;
        for (int x : arr) {
            actualTime += x / mid;
            if (x % mid != 0) {
                actualTime++;
            }
        }
        return actualTime <= h;
    }

}
