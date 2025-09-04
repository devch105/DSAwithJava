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

            while (!q.isEmpty()) {   // ✅ fixed condition
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

        public static int HeightOfTree(Node root){
             if(root==null){
                 return 0;
             }
             int leftheight=HeightOfTree(root.left);
             int rightheight=HeightOfTree(root.right);

             int root_height=Math.max(leftheight,rightheight)+1;
       return root_height;
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, 100, -1, 5, -1, 90, 3, -1, 6, 80, -1 };

        BinaryTree Btree = new BinaryTree();
        Node root = Btree.BuildTree(nodes);

        System.out.println("Preorder:");
        Btree.preOrder(root);
        System.out.println("\n-------------------------");

        System.out.println("Inorder:");
        Btree.InOrder(root);
        System.out.println("\n-------------------------");

        System.out.println("Postorder:");
        Btree.PostOrder(root);
        System.out.println("\n-------------------------");

        System.out.println("Level Order:");
        Btree.Levelorder(root);
        System.out.println("\n--------------------------");

        System.out.println("Height Of Tree : "+ Btree.HeightOfTree(root));

    }
}
