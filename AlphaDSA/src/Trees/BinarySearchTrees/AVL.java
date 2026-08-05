package Trees.BinarySearchTrees;

public class AVL {
    // SELF BALANCING BST
    // -2 < |HL - HR| < 2
    static class TreeNode {
        int val, height;;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.height = 1;
            this.right = null;
        }
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalanceFactor(root);

        // Left Left Case
        if (bf > 1 && key < root.left.val) {
            return rightRotate(root);
        }
        // Right Right Case
        if (bf < -1 && key > root.right.val) {
            return leftRotate(root);
        }
        // Left Right Case
        if (bf > 1 && key > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (bf < -1 && key < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return y;
    }

    public static TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // return new root
        return x;
    }

    public int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public TreeNode createAVLTree(int[] nodes) {
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        return root;
    }

    public void printTree(TreeNode root) {
        System.out.println("Root");
        printTree(root, "", true);
    }

    private void printTree(TreeNode node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (node.left != null || node.right != null) {

            if (node.left != null && node.right != null) {
                printTree(node.left, childPrefix, false);
                printTree(node.right, childPrefix, true);
            } else if (node.left != null) {
                printTree(node.left, childPrefix, true);
            } else {
                printTree(node.right, childPrefix, true);
            }
        }
    }

}
