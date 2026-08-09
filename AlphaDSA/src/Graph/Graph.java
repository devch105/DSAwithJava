package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

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

        int v = 9;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize ArrayLists
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 2));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 4, 2));

        // Vertex 2
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 3, 2));

        // Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 2));
        graph[3].add(new Edge(3, 5, 4));

        // Vertex 4
        graph[4].add(new Edge(4, 1, 2));
        graph[4].add(new Edge(4, 5, 1));

        // Vertex 5
        graph[5].add(new Edge(5, 3, 4));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 2));

        // Vertex 6
        graph[6].add(new Edge(6, 5, 2));

        // vertex 7
        graph[7].add(new Edge(7, 8, 2));
        //vertex 8

        graph[7].add(new Edge(8, 7, 2));

        return graph;
    }

    // print Graph
    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                System.out.println(graph[i].get(j).toString());
            }
        }
    }

    /************** TRAVERSALS ************/

    // BFS Tranversal
    public static void Bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                // print
                System.out.print(curr + "-");
                // check visted true
                vis[curr] = true;

                // push its neighbours / destination
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    public static void Dfs(ArrayList<Edge>[] graph, int idx, boolean vis[]) {

        // print
        System.out.print(idx + "-");

        // check visted True
        vis[idx] = true;

        // visit neighbours

        for (int i = 0; i < graph[idx].size(); i++) {
            Edge curr = graph[idx].get(i);
            if (!vis[curr.dest]) {
                Dfs(graph, curr.dest, vis);
            }
        }
        System.out.println();
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean vis[]) {
        // check if source and destination are same
        if (source == destination) {
            return true;
        }
        // mark visted true
        vis[source] = true;

        // check for neighbours

        for (int i = 0; i < graph[source].size(); i++) {

            Edge curr = graph[source].get(i);

            if (!vis[curr.dest] && hasPath(graph, curr.dest, destination, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Graph Data Structure : ");

        Graph g = new Graph();

        /*
         * 
         * 
         * 5
         * 0 ------- 1
         * | |\
         * 2| 3| \2
         * | | \
         * 2 | 4
         * | | /1
         * | | /
         * 2 ------- 3
         * |
         * 4
         * |
         * 5
         * |
         * 2
         * |
         * 6
         * 
         * 
         */
        ArrayList<Edge>[] graph = g.createGraph();
        printGraph(graph);
        System.out.println("---BFS----");
        // Bfs(graph); // Adjacency List T:O(V+E) and if use matrix T: O(v^2);
        System.out.println("\n ---- DFS -----");
        boolean vis[] = new boolean[graph.length];
        // Dfs(graph, 0,vis); // T:O(V+E
        System.out.println("Check Path : "+hasPath(graph, 0, 8, vis));

    }
}
