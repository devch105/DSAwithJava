package Trees.LeetcodeQuestions;

public class P_2265 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 0, 1, -1, 6};
        TreeNode tree = new TreeNode();

        TreeNode root = tree.BuildTree(arr);
        tree.printTree(root);
        System.out.println("Answer : "+averageOfSubtree(root));
    }

     static  int counter =0;
    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return counter;
    }

    public static int[] dfs(TreeNode root){
        if(root == null){
            return new int[] {0,0};
        }

        int left [] = dfs(root.left);
        int right [] = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        int avg = sum/count;

        if(avg == root.val){
            counter++;
        }
        return new int[] {sum,count};
    }
}
