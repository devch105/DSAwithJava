package Trees.BinarySearchTrees;

import java.util.Arrays;

import Trees.BinarySearchTrees.BST.TreeNode;

public class Main {

    public static void main(String[] args) {
        int nodes[] = { 30, 40, 10, 60, 80};
        BST bst = new BST();
        TreeNode root1 = bst.createBst(nodes);
        bst.printTree(root1);
        int nodes2[] = {20, 50, 15, 70, 90, 100};
        TreeNode root2 = bst.createBst(nodes2);
        bst.printTree(root2);

        // Arrays.sort(nodes);
        // TreeNode root2 = bst.createTreeFromSortedArray(nodes, 0, nodes.length - 1);
        // bst.printTree(root2);
        // bst.convertBSTtoBalancedBST(root);
        // bst.printTree(root);
        // System.out.println("Largest BST in BT : " + bst.largestBstInBt(root));
        // System.out.println(""+bst.maxBst);


        TreeNode root3 = bst.mergeTwoBSTs(root1, root2);
        bst.printTree(root3);

    }
}