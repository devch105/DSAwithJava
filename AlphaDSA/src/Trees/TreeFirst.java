package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFirst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int indx = -1;

        public static Node BuildTree(int nodes[]) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[indx]);

            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void InOrder(Node root) {
            if (root == null) {
                return;
            }
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

        public static void PostOrder(Node root) {
            if (root == null) {
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void Levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) { // ✅ fixed condition
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public static int HeightOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = HeightOfTree(root.left);
            int rightHeight = HeightOfTree(root.right);

            int rootHeight = Math.max(leftHeight, rightHeight) + 1;

            return rootHeight;
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            int totalCounts = leftCount + rightCount + 1;
            return totalCounts;
        }

        public static int SumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = SumOfNodes(root.left);
            int rightSum = SumOfNodes(root.right);

            int totalSum = leftSum + rightSum + root.data;

            return totalSum;
        }

        public static int DiameterO2(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDiam = DiameterO2(root.left);
            int leftHeight = HeightOfTree(root.left);
            int rightDiam = DiameterO2(root.right);
            int rightHeight = HeightOfTree(root.right);

            int selfDiam = leftHeight + rightHeight + 1;

            return Math.max(Math.max(rightDiam, leftDiam), selfDiam);
        }

        static class Info {
            int diam;
            int height;

            public Info(int diam, int height) {
                this.diam = diam;
                this.height = height;
            }
        }

        public static Info diameterOfTree(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameterOfTree(root.left);
            Info rightInfo = diameterOfTree(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;

            return new Info(diam, height);
        }

        public boolean isIdentical(Node root, Node subRoot) {
            if (root == null && subRoot == null) {
                return true;
            } else if (root == null || subRoot == null || subRoot.data != root.data) {
                return false;
            }

            if (!isIdentical(root.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(root.right, subRoot.right)) {
                return false;
            }

            return true;
        }

        public boolean isSubTree(Node root, Node subRoot) {
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }

            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree Btree = new BinaryTree();
        Node root = Btree.BuildTree(nodes);

        System.out.println("Preorder:");
        Btree.preOrder(root);

        Btree.indx = -1;
        int nodesB[] = { 2, 4, -1, -1, 5, -1, -1 };
        Node subRoot = Btree.BuildTree(nodesB);
        System.out.println("\nPreorder:");
        Btree.preOrder(subRoot);

        System.out.println("\nIs Tree B SubTree of A : " + Btree.isSubTree(root, subRoot));
    }
}
