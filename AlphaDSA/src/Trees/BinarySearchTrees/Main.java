package Trees.BinarySearchTrees;

import Trees.BinarySearchTrees.BST.TreeNode;

public class Main {

    public static void main(String[] args) {
        int nodes [] = {5,1,3,4,2,7};
        BST bst = new BST();
        TreeNode root = bst.createBst(nodes);
        bst.preOrder(root);
        System.out.println("-----------");
        bst.inOrder(root);
        System.out.println("Found in BST : "+bst.search(root, 7));
    }
}
