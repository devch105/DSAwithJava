
package Trees.LeetcodeQuestions;

public class P_99 {

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

   public static void main(String[] args) {

    TreeNode tr = new TreeNode();

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(2);

    System.out.println("Before recovery:");
    tr.printPreorder(root);

    P_99 p = new P_99();
    p.recoverTree(root);

    System.out.println("\nAfter recovery:");
    tr.printPreorder(root);
}

    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;

        inorder(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}
