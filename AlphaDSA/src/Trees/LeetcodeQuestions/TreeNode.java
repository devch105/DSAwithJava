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

    public TreeNode createTree() {
        int arr[] = { 4, 2, 7, 1, 3, 6, 9 };

        TreeNode root = BuildTree(arr);
        return root;
    }

    int indx = -1;

    public TreeNode BuildTree(int[] arr) {

    if (arr == null || arr.length == 0 || arr[0] == -1) {
        return null;
    }

    TreeNode root = new TreeNode(arr[0]);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int i = 1;

    while (i < arr.length) {

        TreeNode current = queue.poll();

        // Left child
        if (i < arr.length && arr[i] != -1) {
            current.left = new TreeNode(arr[i]);
            queue.add(current.left);
        }
        i++;

        // Right child
        if (i < arr.length && arr[i] != -1) {
            current.right = new TreeNode(arr[i]);
            queue.add(current.right);
        }
        i++;
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
