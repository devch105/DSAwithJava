package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

    // ============================================================
    // EDGE CLASS
    // ============================================================

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

    // ============================================================
    // CREATE GRAPH
    // ============================================================

    public ArrayList<Edge>[] createGraph() {

        int v = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize graph
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * Graph:
         *
         * 3
         * 0 -------> 1
         * | | \
         * |2 | \ 5
         * ↓ ↓ ↓
         * 2 -------> 3 → 4
         * | |
         * |2 |2
         * ↓ ↓
         * 5 ←--
         *
         * Edges:
         *
         * 0 → 1 (3)
         * 0 → 2 (2)
         * 1 → 3 (-1)
         * 1 → 4 (5)
         * 2 → 3 (6)
         * 3 → 4 (-3)
         * 3 → 5 (2)
         * 4 → 5 (2)
         *
         * This is a DAG.
         *
         * NOTE:
         * This graph contains negative weights,
         * so Dijkstra should NOT be used on this graph.
         */

        // Vertex 0
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 2));

        // Vertex 1
        graph[1].add(new Edge(1, 3, -1));
        graph[1].add(new Edge(1, 4, 5));

        // Vertex 2
        graph[2].add(new Edge(2, 3, 6));

        // Vertex 3
        graph[3].add(new Edge(3, 4, -3));
        graph[3].add(new Edge(3, 5, 2));

        // Vertex 4
        graph[4].add(new Edge(4, 5, 2));

        return graph;
    }

    // crate graph 2
    public static ArrayList<Edge>[] createGraph2() {

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // A = 0
        // B = 1
        // C = 2
        // D = 3
        // E = 4
        // F = 5
        // G = 6

        // A - B = 4
        graph[0].add(new Edge(0, 1, 4));
        graph[1].add(new Edge(1, 0, 4));

        // A - C = 2
        graph[0].add(new Edge(0, 2, 2));
        graph[2].add(new Edge(2, 0, 2));

        // A - D = 7
        graph[0].add(new Edge(0, 3, 7));
        graph[3].add(new Edge(3, 0, 7));

        // B - E = 3
        graph[1].add(new Edge(1, 4, 3));
        graph[4].add(new Edge(4, 1, 3));

        // C - D = 1
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        // C - F = 5
        graph[2].add(new Edge(2, 5, 5));
        graph[5].add(new Edge(5, 2, 5));

        // D - E = 2
        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 3, 2));

        // D - F = 3
        graph[3].add(new Edge(3, 5, 3));
        graph[5].add(new Edge(5, 3, 3));

        // D - G = 2
        graph[3].add(new Edge(3, 6, 2));
        graph[6].add(new Edge(6, 3, 2));

        // E - G = 6
        graph[4].add(new Edge(4, 6, 6));
        graph[6].add(new Edge(6, 4, 6));

        // F - G = 4
        graph[5].add(new Edge(5, 6, 4));
        graph[6].add(new Edge(6, 5, 4));

        return graph;
    }

    // ============================================================
    // PRINT GRAPH
    // ============================================================

    public static void printGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge edge : graph[i]) {
                System.out.println(edge);
            }
        }
    }

    // TRAVERSALS
    // -------------------- BFS --------------------

    public static void Bfs(ArrayList<Edge>[] graph) {

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[graph.length];

        // Start from vertex 0
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int curr = q.remove();

            System.out.print(curr + " -> ");

            // Add unvisited neighbours
            for (Edge e : graph[curr]) {

                if (!vis[e.dest]) {

                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }

        System.out.println("END");
    }

    // -------------------- DFS --------------------

    public static void Dfs(
            ArrayList<Edge>[] graph,
            int idx,
            boolean[] vis) {

        // Print current vertex
        System.out.print(idx + " -> ");

        // Mark visited
        vis[idx] = true;

        // Visit neighbours
        for (Edge e : graph[idx]) {

            if (!vis[e.dest]) {
                Dfs(graph, e.dest, vis);
            }
        }
    }

    // -------------------- HAS PATH --------------------

    public static boolean hasPath(
            ArrayList<Edge>[] graph,
            int source,
            int destination,
            boolean[] vis) {

        // Source and destination are same
        if (source == destination) {
            return true;
        }

        // Mark source as visited
        vis[source] = true;

        // Check neighbours
        for (Edge e : graph[source]) {

            if (!vis[e.dest]) {

                if (hasPath(
                        graph,
                        e.dest,
                        destination,
                        vis)) {

                    return true;
                }
            }
        }

        return false;
    }

    // ============================================================
    // DEGREE
    // ============================================================

    // Calculate In-Degree and Out-Degree
    public static void findInDeg_OutDeg(
            ArrayList<Edge>[] graph,
            int[] inDeg,
            int[] outDeg) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge e : graph[i]) {

                // Edge: e.src -> e.dest

                outDeg[e.src]++;
                inDeg[e.dest]++;
            }
        }
    }

    // ============================================================
    // TOPOLOGICAL SORT
    // ============================================================

    // Topological Sort using BFS
    // Also known as Kahn's Algorithm

    public static void topologicalSort(
            ArrayList<Edge>[] graph) {

        int v = graph.length;

        // Calculate in-degree
        int[] inDeg = new int[v];

        for (int i = 0; i < v; i++) {

            for (Edge e : graph[i]) {
                inDeg[e.dest]++;
            }
        }

        // Queue for vertices having in-degree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {

            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        System.out.print("Topological Sort: ");

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            System.out.print(curr + " ");

            count++;

            // Remove current vertex's outgoing edges
            for (Edge e : graph[curr]) {

                inDeg[e.dest]--;

                // If in-degree becomes 0,
                // add it to queue
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();

        // If all vertices were not processed,
        // graph contains a cycle
        if (count != v) {
            System.out.println(
                    "Graph contains a cycle!");
        }
    }

    // ============================================================
    // ALL PATHS FROM SOURCE TO TARGET
    // ============================================================

    public static void sourceToTarget(
            ArrayList<Edge>[] graph,
            int s,
            int t,
            String path) {

        // Destination reached
        if (s == t) {

            System.out.println(path + t);

            return;
        }

        // Visit every neighbour
        for (Edge e : graph[s]) {

            sourceToTarget(
                    graph,
                    e.dest,
                    t,
                    path + s + "->");
        }
    }

    // ============================================================
    // DIJKSTRA ALGORITHM
    // ============================================================

    static class Pair {

        int n;
        int pt;

        public Pair(int n, int pt) {
            this.n = n;
            this.pt = pt;
        }
    }

    public static void dijkstra(
            ArrayList<Edge>[] graph,
            int src) {

        int[] dist = new int[graph.length];

        boolean[] vis = new boolean[graph.length];

        // Initially all vertices are unreachable
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself
        dist[src] = 0;

        // Min heap based on path distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.pt, b.pt));

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            // Ignore already processed vertex
            if (vis[curr.n]) {
                continue;
            }

            vis[curr.n] = true;

            // Explore neighbours
            for (Edge e : graph[curr.n]) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxation
                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;

                    pq.add(
                            new Pair(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < dist.length; i++) {

            if (dist[i] == Integer.MAX_VALUE) {

                System.out.println(
                        src + " -> " + i + " = INF");

            } else {

                System.out.println(
                        src + " -> " + i + " = " + dist[i]);
            }
        }
    }

    // ============================================================
    // BELLMAN-FORD ALGORITHM
    // ============================================================

    public static void bellmanFord(
            ArrayList<Edge>[] graph,
            int src) {

        int v = graph.length;

        int[] dist = new int[v];

        // Initially all vertices are unreachable
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source distance
        dist[src] = 0;

        /*
         * Relax all edges V - 1 times.
         *
         * Why V - 1?
         *
         * A simple shortest path can contain
         * at most V - 1 edges.
         */

        for (int i = 0; i < v - 1; i++) {

            for (int j = 0; j < graph.length; j++) {

                for (int k = 0; k < graph[j].size(); k++) {

                    // IMPORTANT:
                    // j = source vertex
                    // k = edge index
                    Edge e = graph[j].get(k);

                    // Relax edge only if source is reachable
                    if (dist[e.src] != Integer.MAX_VALUE &&
                            dist[e.src] + e.wt < dist[e.dest]) {

                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }

        // ========================================================
        // NEGATIVE CYCLE DETECTION
        // ========================================================

        for (int j = 0; j < graph.length; j++) {

            for (int k = 0; k < graph[j].size(); k++) {

                Edge e = graph[j].get(k);

                /*
                 * If we can still relax an edge after
                 * V - 1 iterations, a negative cycle exists.
                 */

                if (dist[e.src] != Integer.MAX_VALUE &&
                        dist[e.src] + e.wt < dist[e.dest]) {

                    System.out.println(
                            "Graph contains a negative cycle!");

                    return;
                }
            }
        }

        // ========================================================
        // PRINT SHORTEST DISTANCES
        // ========================================================

        for (int i = 0; i < dist.length; i++) {

            if (dist[i] == Integer.MAX_VALUE) {

                System.out.println(
                        src + " -> " + i + " = INF");

            } else {

                System.out.println(
                        src + " -> " + i + " = " + dist[i]);
            }
        }
    }

    // ====================================================
    // PRIMS Algorithim ----> Total minimum MST
    // ====================================================

    static class Pairs {
        int v;
        int cost;

        public Pairs(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void primsAlgo(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new Pairs(0, 0));

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pairs curr = pq.poll();

            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                for (Edge e : graph[curr.v]) {
                    pq.offer(new Pairs(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final Cost of MST : " + finalCost);
    }

    // ====================================================
    // Question : Cheapest flights within k Stops
    // ====================================================

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

    public static int cheapesFlight(int n, int flights[][], int src, int dest, int k) {
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

                if (dist[u] != Integer.MAX_VALUE
                        && dist[u] + wt < dist[v]
                        && curr.stop <= k) {
                    dist[v] = dist[u] + wt;
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

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        System.out.println("Graph Data Structure");

        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dist = 3, k = 1;

        System.out.println(" Answer : "+cheapesFlight(n, flights, src, dist, k));

        // ========================================================
        // CREATE GRAPH
        // ========================================================

        // ArrayList<Edge>[] graph = g.createGraph();
        // ArrayList<Edge>[] graph = g.createGraph2();

        // ========================================================
        // PRINT GRAPH
        // ========================================================

        // System.out.println(
        // "\n--- Graph ---");

        // printGraph(graph);

        // ========================================================
        // BFS
        // ========================================================

        // System.out.println(
        // "\n--- BFS ---");

        // Bfs(graph);

        // ========================================================
        // DFS
        // ========================================================

        // System.out.println(
        // "\n--- DFS ---");

        // boolean[] dfsVis = new boolean[graph.length];

        // Dfs(
        // graph,
        // 0,
        // dfsVis);

        // System.out.println("END");

        // ========================================================
        // HAS PATH
        // ========================================================

        // System.out.println(
        // "\n--- Has Path ---");

        // boolean[] pathVis = new boolean[graph.length];

        // System.out.println(
        // "Path from 0 to 5: " +
        // hasPath(
        // graph,
        // 0,
        // 5,
        // pathVis));

        // ========================================================
        // IN-DEGREE / OUT-DEGREE
        // ========================================================

        // System.out.println(
        // "\n--- In-Degree / Out-Degree ---");

        // int[] inDeg = new int[graph.length];

        // int[] outDeg = new int[graph.length];

        // findInDeg_OutDeg(
        // graph,
        // inDeg,
        // outDeg);
        //
        // for (int i = 0; i < graph.length; i++) {

        // System.out.println(
        // "Vertex " + i +
        // " -> In-Degree: " + inDeg[i] +
        // ", Out-Degree: " + outDeg[i]);
        // }

        // ========================================================
        // TOPOLOGICAL SORT
        // ========================================================

        // System.out.println(
        // "\n--- Topological Sort ---");

        // topologicalSort(graph);

        // ========================================================
        // ALL PATHS
        // ========================================================

        // System.out.println(
        // "\n--- All Paths from Source to Target ---");

        // sourceToTarget(
        // graph,
        // 0,
        // 4,
        // "");

        // ========================================================
        // DIJKSTRA
        // ========================================================

        /*
         * DO NOT RUN Dijkstra on this graph.
         *
         * This graph contains negative edges:
         *
         * 1 -> 3 = -1
         * 3 -> 4 = -3
         *
         * Dijkstra requires non-negative edge weights.
         */

        // System.out.println(
        // "\n--- Dijkstra Algorithm ---"
        // );
        // dijkstra(graph, 0);

        // ========================================================
        // BELLMAN-FORD
        // ========================================================

        // System.out.println(
        // "\n--- Bellman-Ford Algorithm ---");

        // bellmanFord(
        // graph,
        // 0);

        // ========================================================
        // PRIMS-ALGO
        // ========================================================
        // primsAlgo(graph);
    }
}