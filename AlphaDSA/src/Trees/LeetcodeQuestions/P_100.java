package Trees.LeetcodeQuestions;

public class P_100 {
    // Same Tree 

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        int arr [] = {1,2,3};
        TreeNode rooNode = node.BuildTree(arr);
        TreeNode copyTree = rooNode;

         int brr [] = {1,2,4};
         TreeNode newNode = node.BuildTree(brr);
       
        System.out.println("Answer : "+isSameTree(rooNode, copyTree));
        System.out.println("Answer : "+isSameTree(copyTree, newNode));
    }



    public static  boolean isSameTree(TreeNode p, TreeNode q) {
     if(p == null && q ==null){         // correct condition 
        return true;
     }
     
       if(p == null || q== null || p.val != q.val){     // Incorrect condition 
        return false;
       } 
      boolean left =  isSameTree(p.left, q.left);          // Recursion
      boolean right = isSameTree(p.right, q.right);

      return left & right;    // send result to upper level
    }
}
