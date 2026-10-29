package Trees.LeetcodeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_515 {
    
    // 515. Find Largest Value in Each Tree Row
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root = node.buildBST();

        System.out.println("Answer : "+largestValues(root));
    }

     public static  List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Guard against null root
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // Freeze the size for the current level
            int max = Integer.MIN_VALUE; // Track max using primitive to avoid stream overhead

            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                max = Math.max(max, node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}
