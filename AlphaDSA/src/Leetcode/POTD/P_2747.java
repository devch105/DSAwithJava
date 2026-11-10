package POTD;

import java.util.ArrayList;
import java.util.HashSet;

public class P_2747 {

    // Leetcode Count Zero Request servers
    public static void main(String[] args) {

        int n = 3;
        int logs[][] = { { 1, 3 }, { 2, 6 }, { 1, 5 } };
        int x = 5;
        int queries[] = { 10, 11 };

        System.out.println("Answer : " + countServers(n, logs, x, queries));
    }

    public static ArrayList<Integer> countServers(int n, int[][] logs, int x, int[] queries) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int q : queries) {

            HashSet<Integer> set = new HashSet<>();

            for (int[] log : logs) {

                int svr_id = log[0];
                int time = log[1];

                int X = q - x;
                if (time >= X && time <= q) {
                    set.add(svr_id);
                }
            }

            list.add(n - set.size());
        }

        return list;
    }
}
