//package POTD.GFG;
//
//public class levelordertraversal {
//    static void levelOrderRec(Node root, int level, ArrayList<ArrayList<Integer>> res) {
//        if (root == null) return;
//
//        // Add a new level to the result if needed
//        if (res.size() <= level)
//            res.add(new ArrayList<>());
//
//        // Add current node's data to its corresponding level
//        res.get(level).add(root.data);
//
//        // Recur for left and right children
//        levelOrderRec(root.left, level + 1, res);
//        levelOrderRec(root.right, level + 1, res);
//    }
//
//    // Function to perform level order traversal
//    static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        levelOrderRec(root, 0, res);
//        return res;}
//}
