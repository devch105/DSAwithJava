package Trees.LeetcodeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_4015 {

    public static void main(String[] args) {
        // int[] parent = { -1, 0, 0, 0, 2, 2 }
        // , nums = { 5, 2, 3, 1, 4, 6 };
        int[] parent = {
                -1, 0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
                29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
                49, 50, 51, 52, 53, 54, 55, 56, 57, 58,
                59, 60, 61, 62, 63, 64, 65, 66, 67, 68,
                69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
                89, 90, 91, 92, 93, 94, 95, 96, 97, 98
        };

        int[] nums = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                91, 92, 93, 94, 95, 96, 97, 98, 99, 100
        };

        weightedSum(parent, nums);
    }

    public static void weightedSum(int[] parent, int[] nums) {

        int n = parent.length;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.println(i + "-> :" + graph[i].get(j));
            }
        }

        int depth[] = new int[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        depth[0] = 1;
        int height = 1;

        while (!q.isEmpty()) {

            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                int child = graph[curr].get(i);
                depth[child] = depth[curr] + 1;
                height = Math.max(height, depth[child]);
                q.add(child);
            }
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += (long) nums[i] * (height - depth[i] + 1);
        }

        System.out.println("Answer : " + answer);
    }

}
