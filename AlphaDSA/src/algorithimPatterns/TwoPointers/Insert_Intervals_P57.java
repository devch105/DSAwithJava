package algorithimPatterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Intervals_P57 {

    static void main() {

        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };

        int[] newInterval = {4,8};

        System.out.println("Answer : " +
                Arrays.deepToString(
                        insertIntervals(intervals, newInterval)
                ));
    }

    public static int[][] insertIntervals(int[][] intervals,
                                          int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> list = new ArrayList<>();

        int i = 0;

        // 1. Add all non-overlapping intervals before new interval

        while (i < intervals.length &&
                intervals[i][1] < start) {

            list.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals

        while (i < intervals.length &&
                intervals[i][0] <= end) {

            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);

            i++;
        }

        list.add(new int[]{start, end});

        // 3. Add remaining intervals

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}