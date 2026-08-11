package Graph.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_787 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    src +
                    " , " +
                    dest +
                    " , " +
                    wt +
                    " }";
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        public Info(int v, int cost, int stop) {
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public static ArrayList<Edge>[] createGraphy(int arr[][], int n) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {

            int src = arr[i][0];
            int dest = arr[i][1];
            int cost = arr[i][2];

            Edge e = new Edge(src, dest, cost);

            graph[src].add(e);

        }
        return graph;
    }

    public static int findCheapestPrice(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge>[] graph = createGraphy(flights, n);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v]
                        && curr.stop <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void main(String[] args) {

        int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        int n = 4, src = 0, dst = 3, k = 1;
        // answer 6;
        System.out.println("Answer : " + findCheapestPrice(n, flights, src, dst, k));
    }
}
