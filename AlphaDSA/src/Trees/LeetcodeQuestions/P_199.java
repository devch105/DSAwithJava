package Trees.LeetcodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class P_199 {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode rNode = new TreeNode();
        rNode = rNode.buildTree();

        rightView(rNode, 1);

        ArrayList<Integer> list = new ArrayList<>();
        for (int level = 1; level <= map.size(); level++) {
            list.add(map.get(level));
        }
        System.out.println("List : " + list);

        System.out.println("Map : "+map.toString());
    }

    public static void rightView(TreeNode root, int level) {

        if (root == null) {
            return;
        }

       
        if (!map.containsKey(level)) {
            map.put(level, root.val);
        }

        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }
}
