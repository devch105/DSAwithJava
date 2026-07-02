package algorithimPatterns.BinarySearch;

public class P_2187_MinimumTimeToCompleteTheTrip {
    public static void main(String[] args) {
        int[] time = { 1, 2, 3 };
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }

    public static long minimumTime(int[] time, int totalTrips) {

        long left = 1;
        int min = time[0];
        for (int t : time) {
            min = Math.min(min, t);
        }
        long right = (long) min * totalTrips;
        long ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(time, totalTrips, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] time, int totalTrips, long mid) {
        long trips = 0;
        for (int t : time) {
            trips += mid / t;
        }
        return trips >= totalTrips;
    }
}
