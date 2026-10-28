package Graph.Leetcode;
import java.util.*;

public class P_133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            HashMap<Node, Node> map = new HashMap<>();
            return dfs(node, map);
        }

        private Node dfs(Node node, HashMap<Node, Node> map) {
            if (node == null) {
                return null;
            }

            if (map.containsKey(node)) {
                return map.get(node);
            }

            Node copy = new Node(node.val);
            map.put(node, copy);

            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(dfs(neighbor, map));
            }

            return copy;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Build the graph: 1--2, 1--4, 2--3, 3--4
        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        Node clone = new Solution().cloneGraph(node1);

        System.out.println("Original node: " + node1.val);
        System.out.println("Cloned node: " + clone.val);
        System.out.println("Cloned neighbors:");

        for (Node neighbor : clone.neighbors) {
            System.out.println(neighbor.val);
        }
    }
}
