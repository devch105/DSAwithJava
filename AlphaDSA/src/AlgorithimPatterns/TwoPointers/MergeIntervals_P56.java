package AlgorithimPatterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_P56 {
    public static void main(String[] args) {

        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println("Answer : " + Arrays.deepToString(mergeIntervals(arr)));
    }

/*    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] newIntervals = intervals[0];
        list.add(newIntervals);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= newIntervals[1]) {
                // overlapping
                newIntervals[1] = Math.max(newIntervals[1], interval[1]);
            } else {
                newIntervals = interval;
                list.add(newIntervals);
            }
        }

        return list.toArray(new int[list.size()][]);
    }*/

    public static int[][] mergeIntervals(int[][] intervals) {
        // Arrays sort
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int start=intervals[0][0],end=intervals[0][1];
        List<int[]> res = new ArrayList<>();

        for(int i=1; i<intervals.length;i++){
            int s=intervals[i][0],e=intervals[i][1];
            if(s<=end){
                end=Math.max(e,end);
            }else{
                res.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }

} 