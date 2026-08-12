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
}
