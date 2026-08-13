package Trees.LeetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class P_297 {

    public static void main(String[] args) {

        int arr[] = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        TreeNode root = new TreeNode().BuildTree(arr);
        System.out.println("Before Serialization");
        System.out.println("\n");
        String data = serialize(root);
        System.out.println("Serialized Tree : " + data);
        TreeNode root2 = deserialize(data);
        System.out.println("\n After Serialization : ");
        System.out.println();
        root.printTree(root2);

    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        StringBuilder data = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                data.append("N,");
                continue;
            }
            data.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);

        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("N")) {
            return null;
        }
        String[] values = data.split(",");
        // System.out.println("Array Values : " + Arrays.toString(values));

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;

        while (!q.isEmpty() && index < values.length) {
            TreeNode curr = q.remove();
            // System.out.println("curr Element : " + curr.val);

            if (!values[index].equals("N")) {

                curr.left = new TreeNode(Integer.parseInt(values[index]));
                q.add(curr.left);
            }
            index++;

            if (index < values.length && !values[index].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(values[index]));
                q.add(curr.right);
            }
            index++;
        }

        return root;
    }
}
