package Trees.BinarySearchTrees;

public class AVL {


    //  SELF BALANCING BST


    //  |HL_HR|   < 2
    
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
