package Trees.LeetcodeQuestions;

public class P_226 {

    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        int arr[] = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = new TreeNode();
        root = root.buildTree(arr);
        printPreorder(root);
        System.out.println();
        TreeNode newRoot = invertTree(root);
        printPreorder(newRoot);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        left = right;
        right = temp;

        root.left = left;
        root.right = right;
        return root;
    }
}
