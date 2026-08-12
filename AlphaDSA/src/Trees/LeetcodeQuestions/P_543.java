package Trees.LeetcodeQuestions;

public class P_543 {
    
    static int diameter =0;
    public static void main(String[] args) {
         
        TreeNode root = new TreeNode();
        root = root.buildTree();
        root.printTree(root);
        height(root);
        System.out.println("Diameter : "+diameter);

    }

    public static int height (TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);
         
        diameter = Math.max(diameter, left+right);
        int ht = Math.max(left, right)+1;

        return ht;
    }
}
