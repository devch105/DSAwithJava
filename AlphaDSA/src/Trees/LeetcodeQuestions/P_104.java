package Trees.LeetcodeQuestions;

public class P_104 {

    static class TreeNode {
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
    }

    public static void main(String[] args) {

        TreeNode t = new TreeNode(1);
        TreeNode tl = new TreeNode(2);
        TreeNode tr = new TreeNode(2);
        TreeNode tll = new TreeNode(2);
        TreeNode tlr = new TreeNode(2);
        TreeNode trl = new TreeNode(2);
        t.left = tl;
        t.right = tr;
        t.left.left = tll;
        t.left.right = tlr;
        t.right.left = trl;   

         System.out.println("Max Depth : "+maxDepth(t));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
