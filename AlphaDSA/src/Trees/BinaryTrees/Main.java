package Trees.BinaryTrees;

import Trees.BinaryTrees.BinaryTree.Node;

public class Main {
    public static void main(String[] args) {
       int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);
        System.out.println("PreOrder :");
        tree.preOrder(root);
        System.out.println("");
        System.out.println("LevelOrder :");
        tree.Levelorder(root);

        // // Invert Binary Tree Q:226
        // System.out.println("P:226 -> Inverted Binary Tree  :");
        // Node invertedRoot = tree.invertBinaryTree(root);
        // tree.Levelorder(invertedRoot);

        System.out.println("Right View of Binary Tree Q:199 : "+tree.rightSideView(root).toString());
    }
}
