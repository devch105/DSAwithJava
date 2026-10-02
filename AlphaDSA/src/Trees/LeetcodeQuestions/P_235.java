package Trees.LeetcodeQuestions;

public class P_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        root = root.buildBST();

        System.out.println("LCA : " + lowestCommonAncestor(root, new TreeNode(1), new TreeNode(3)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            System.out.println("X-> : "+root.val);
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        if (rightLca == null) {
            System.out.println("L-> : "+leftLca.val);
            return leftLca;
        }
        if (leftLca == null) {
              System.out.println("R-> : "+rightLca.val);
            return rightLca;
        }

        System.out.println("C-> :"+root.val);
        return root;
    }

}
