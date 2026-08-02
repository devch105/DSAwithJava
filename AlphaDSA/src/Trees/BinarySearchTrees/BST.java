package Trees.BinarySearchTrees;

public class BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public TreeNode createBst(int nodes[]) {
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void inOrder(TreeNode root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.println(root.val+",");
        inOrder(root.right);
    }

    public boolean search(TreeNode root , int key){
        if(root==null){
            return false;
        }
        if(root.val==key)return true;
      
    return key>root.val?search(root.right, key):search(root.left, key);
    }


    public 
}
