package Trees.LeetcodeQuestions;

public class P_98 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root = root.buildBST();

        System.out.println("Tree is valid ? : " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return checkValid(root, min, max, "");
    }

    public static boolean checkValid(TreeNode root, long min, long max, String str) {

        if (root == null) {
            return true;
        }
        System.out.println("->" + str + root.val);
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return checkValid(root.left, min, root.val, "l") && checkValid(root.right, root.val, max, "r");
    }

}
