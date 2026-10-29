package Trees.LeetcodeQuestions;

public class P_110 {
    public static void main(String[] args) {
        TreeNode node = new  TreeNode();

        TreeNode root = node.buildBST();

        System.out.println("Answer : "+isBalanced(root));
    }

      public static  boolean isBalanced(TreeNode root) {
       if(heightOfTree(root)!=-1){
        return true;
       }else{
        return false;
       }
    }

    public static  int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left,right) +1;
    }
}
