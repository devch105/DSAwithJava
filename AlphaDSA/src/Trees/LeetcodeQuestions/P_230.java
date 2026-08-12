package Trees.LeetcodeQuestions;

public class P_230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = root.buildBST();
        root.printTree(root);
        inOrder(root, 3);
        System.out.println("Kth smallest : "+result);
    }

    static int count=0; 
    static int result=-2;

    public static void inOrder(TreeNode root, int k){
        if(root==null){
            return ;
        }

        inOrder(root.left, k);
        count++;
        if(count==k){
            result=root.val;
        }
        inOrder(root.right, k);

    }
    
}
