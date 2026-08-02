package Trees.BinarySearchTrees;

import java.util.ArrayList;

import Trees.BinarySearchTrees.BST.TreeNode;

public class Main {

    public static void main(String[] args) {
        int nodes[] = { 5, 1, 3, 4, 2, 7 };
        BST bst = new BST();
        TreeNode root = bst.createBst(nodes);
        bst.preOrder(root);
        System.out.println("-----------");
        bst.inOrder(root);
        System.out.println("Found in BST : " + bst.search(root, 2));

      
        System.out.println("Print Roots to all leaves paths:");
        ArrayList<Integer> path = new ArrayList<>();
        bst.PrintRootToLeaf(root, path);
        System.out.println("Is Valid BST : " + bst.isValidBST(root));
    }
}
