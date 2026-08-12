package Trees.LeetcodeQuestions;

public class P_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        root = root.buildBST();

        System.out.println("LCA : " + lowestCommonAncestor(root, new TreeNode(1), new TreeNode(3)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

}
