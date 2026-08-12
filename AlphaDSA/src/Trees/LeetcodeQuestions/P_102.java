package Trees.LeetcodeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_102 {

    public static void main(String[] args) {
        TreeNode rNode = new TreeNode();
        rNode = rNode.buildTree();

        List<List<Integer>> reList = levelOrder(rNode);
        System.out.println("Answer : " + reList);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                list.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            result.add(list);
        }
        return result;
    }
}
