package Trees.BinarySearchTrees;

import java.util.ArrayList;

public class BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public TreeNode createBst(int nodes[]) {
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + ",");
        inOrder(root.right);
    }

    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key)
            return true;

        return key > root.val ? search(root.right, key) : search(root.left, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void PrintRootToLeaf(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(path.toString());
        }
        PrintRootToLeaf(root.left, path);
        PrintRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return isValidBSTUtil(root, min, max);

    }

    public boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
    }
}
