package Graph.Leetcode;

import java.util.ArrayList;

public class P_1971 {
    public static void main(String[] args) {

        int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
        int n = 6;
        int src = 0;
        int dest = 5;
        System.out.println("Answer : " + validPath(n, edges, src, dest));
    }

    static class Pair {
        int src;
        int dest;

        public Pair(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Pair>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : edges) {
            int src = pair[0];
            int dest = pair[1];
            graph[src].add(new Pair(src, dest));
            // for unidirected Graph
            graph[dest].add(new Pair(dest, src));
        }
        boolean vis[] = new boolean[n];

        return hasPath(graph, source, destination, vis);
    }

    public static boolean hasPath(ArrayList<Pair>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;

        for (Pair p : graph[src]) {
            if (!vis[p.dest]) {
                if (hasPath(graph, p.dest, dest, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
