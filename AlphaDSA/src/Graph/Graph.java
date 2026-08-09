
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

    // Edge class
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

    // Create Graph
    public ArrayList<Edge>[] createGraph() {

        int v = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize graph
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * 1
         * 0 -------> 1
         * | | \
         * 2| 3 | \ 5
         * ↓ ↓ ↓
         * 2 -------> 3 → 4
         * 4 | \
         * 1| \2
         * ↓ ↓
         * 5 ←--
         * 
         * Edges:
         * 
         * 0 → 1
         * 0 → 2
         * 1 → 3
         * 1 → 4
         * 2 → 3
         * 3 → 4
         * 3 → 5
         * 4 → 5
         * 
         * This is a DAG.
         */

        // Vertex 0
        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 2));

        // Vertex 1
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 4, 5)); 

        // Vertex 2
        graph[2].add(new Edge(2, 3, 6));

        // Vertex 3
        graph[3].add(new Edge(3, 4, 2));
        graph[3].add(new Edge(3, 5, 2));

        // Vertex 4
        graph[4].add(new Edge(4, 5, 2));
        return graph;
    }

    // Print Graph
    public static void printGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge edge : graph[i]) {
                System.out.println(edge);
            }
        }
    }

    /**************** TRAVERSALS ****************/

    // BFS Traversal
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

    // DFS Traversal
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

    // Has Path
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

                if (hasPath(graph, e.dest, destination, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**************** DEGREE ****************/

    // Calculate In-Degree and Out-Degree
    public static void findInDeg_OutDeg(
            ArrayList<Edge>[] graph,
            int[] inDeg,
            int[] outDeg) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge e : graph[i]) {

                // Edge: e.src → e.dest

                outDeg[e.src]++;
                inDeg[e.dest]++;
            }
        }
    }

    /**************** TOPOLOGICAL SORT ****************/
    // Topological Sort using BFS
    // Also known as Kahn's Algorithm
    public static void topologicalSort(ArrayList<Edge>[] graph) {

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
        // graph contains a cycle.
        if (count != v) {
            System.out.println("Graph contains a cycle!");
        }
    }

    public static void sourceToTarget(ArrayList<Edge>[] graph, int s, int t, String path) {
        if (s == t) {
            System.out.println(path + "->" + t);
            return;
        }
        for (int i = 0; i < graph[s].size(); i++) {
            Edge e = graph[s].get(i);
            sourceToTarget(graph, e.dest, t, path + s);
        }
    }

    /************* DIJKSTRA ALGORITHIM *************/

    static class Pair {
        int n;
        int pt;

        public Pair(int n, int pt) {
            this.n = n;
            this.pt = pt;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.pt - b.pt); // path based sorting on pairs

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;

                    if (dist[u] + w < dist[v]) { // src + wt < destination weight
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }

                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println("0->" + i + " --- " + dist[i]);
        }
        ;

    }

    public static void main(String[] args) {

        System.out.println("Graph Data Structure");

        Graph g = new Graph();

        // Create Graph
        ArrayList<Edge>[] graph = g.createGraph();

        // Print Graph
        System.out.println("\n--- Graph ---");
        printGraph(graph);

        // BFS
        System.out.println("\n--- BFS ---");
        Bfs(graph);

        // DFS
        System.out.println("\n--- DFS ---");

        boolean[] dfsVis = new boolean[graph.length];

        Dfs(graph, 0, dfsVis);

        System.out.println("END");

        // Has Path
        System.out.println("\n--- Has Path ---");

        boolean[] pathVis = new boolean[graph.length];

        System.out.println(
                "Path from 0 to 5: " +
                        hasPath(graph, 0, 5, pathVis));

        // In-Degree / Out-Degree
        System.out.println("\n--- In-Degree / Out-Degree ---");

        int[] inDeg = new int[graph.length];
        int[] outDeg = new int[graph.length];
        findInDeg_OutDeg(graph, inDeg, outDeg);

        // Topological Sort
        System.out.println("\n--- Topological Sort ---");
        topologicalSort(graph);

        System.out.println("\n All Paths from source to target");
        sourceToTarget(graph, 0, 4, "");

        System.out.println("/n --------------------DIJKSTRA ALGO------------------ ");
        dijkstra(graph, 0);
    }
}
