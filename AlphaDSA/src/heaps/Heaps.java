package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heaps {

    static class Heapy {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;

            while (x > 0) {
                int par = (x - 1) / 2;

                if (arr.get(x) >= arr.get(par))
                    break;

                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
            }

        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }

        public int delete() {
            if (arr.isEmpty()) {
                return -1;
            }
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            // System.out.println("Deleting element: " + temp + ", replacing root with: " +
            // arr.get(0));
            arr.remove(arr.size() - 1);

            heapify(0);
            return temp;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            // System.out.println(
            // "Heapify called on index: " + i + ", left: " + left + ", right: " + right +
            // ", minIdx: " + minIdx);

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, Heaps!");

    }

    public static void testHeap() {
        Heapy h = new Heapy();
        for (int i = 8; i > 0; i--) {
            h.add(i);
        }

        while (!h.arr.isEmpty()) {
            System.out.println("-> " + h.peek());
            h.delete();
        }
    }

    // Problems from Leetcode P:973
    class Points {
        int p1;
        int p2;
        int dist;

        Points(int p1, int p2, int dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new Points(points[i][0], points[i][1], dist));
        }

        for (int i = 0; i < k; i++) {
            Points pair = pq.poll();
            list.add(new int[] { pair.p1, pair.p2 });
        }

        return list.toArray(new int[list.size()][]);
    }

    // Problems from Leetcode P:1046
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (y != x) {
                pq.offer(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    // Problems from Leetcode P:215
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) {
            pq.offer(x);
        }
        int result = -1;
        while (k > 0 && !pq.isEmpty()) {
            result = pq.poll();
            k--;
        }

        return result;
    }

    // Problems from Leetcode P:347
    class Pair {
        int value;
        int freq;

        Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            list.add(p.value);
            k--;
        }

        int arr[] = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

}
