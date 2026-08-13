package Trees.LeetcodeQuestions;

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

    public TreeNode createTree() {
        int arr[] = { 4, 2, 7, 1, 3, 6, 9 };

        TreeNode root = BuildTree(arr);
        return root;
    }

    static int indx = -1;

    public static TreeNode BuildTree(int nodes[]) {
        indx++;
        if (nodes[indx] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(nodes[indx]);

        newNode.left = BuildTree(nodes);
        newNode.right = BuildTree(nodes);

        return newNode;
    }

    // BINARY SEARCH TREE

    public TreeNode buildBST() {

        int[] arr = { 4, 2, 7, 1, 3, 6, 9 };

        return createBST(arr);
    }

    public TreeNode createBST(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = null;

        for (int value : arr) {
            root = insertBST(root, value);
        }

        return root;
    }

    private TreeNode insertBST(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insertBST(root.left, value);
        } else {
            root.right = insertBST(root.right, value);
        }

        return root;
    }
}
