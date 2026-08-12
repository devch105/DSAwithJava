package Trees.LeetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode buildTree() {
        int arr[] = { 4, 2, 7, 1, 3, 6, 9 };

        TreeNode root = createTree(arr);
        return root;
    }

    public TreeNode createTree(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < arr.length) {

            TreeNode current = q.remove();

            // Left child
            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                q.add(current.left);
            }

            // Right child
            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                q.add(current.right);
            }
        }

        return root;
    }

    // BINARY SEARCH TREE

    public TreeNode buildBST() {

        int[] arr = { 4, 2, 7, 1, 3, 6, 9 };

        return createBST(arr);
    }

    public TreeNode createBST(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = null;

        for (int value : arr) {
            root = insertBST(root, value);
        }

        return root;
    }

    private TreeNode insertBST(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insertBST(root.left, value);
        } else {
            root.right = insertBST(root.right, value);
        }

        return root;
    }
}
