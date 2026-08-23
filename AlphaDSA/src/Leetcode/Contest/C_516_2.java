package Leetcode.Contest;

import java.util.ArrayList;
import java.util.HashSet;

public class C_516_2 {
    public static void main(String[] args) {
        int arr[] = { 3, 9, 7 };
        int lower = 1, upper = 12;
        HashSet<Integer> set = new HashSet<>();

        for (int x : arr) {
            set.add(x);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = lower; i <= upper; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        
    }

    public static ArrayList<ArrayList<Integer>> groupRanges(ArrayList<Integer> list, HashSet<Integer> set) {
        ArrayList<ArrayList<Integer>> ranges = new ArrayList<>();

        if (list.isEmpty()) {
            return ranges;
        }
        int start = list.get(0);
        int end = start;

        for (int i = 1; i < list.size(); i++) {

            int curr = list.get(i);

            if (curr == end + 1) {
                end = curr;
            } else {
                ArrayList<Integer> range = new ArrayList<>();
                range.add(start);
                range.add(end);
                ranges.add(range);

                start = curr;
                end = curr;
            }
        }
        ArrayList<Integer> range = new ArrayList<>();
        range.add(start);
        range.add(end);
        ranges.add(range);

        
        return ranges;
    }
}
