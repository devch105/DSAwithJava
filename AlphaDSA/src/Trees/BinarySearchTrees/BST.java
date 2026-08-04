package Trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public void printTree(TreeNode root) {
        System.out.println("Root");
        printTree(root, "", true);
    }

    private void printTree(TreeNode node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (node.left != null || node.right != null) {

            if (node.left != null && node.right != null) {
                printTree(node.left, childPrefix, false);
                printTree(node.right, childPrefix, true);
            } else if (node.left != null) {
                printTree(node.left, childPrefix, true);
            } else {
                printTree(node.right, childPrefix, true);
            }
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

    public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        // System.out.println(root.val + ",");
        list.add(root.val);
        inOrder(root.right, list);
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(node.val + "^");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.println();
        }
    }

    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key)
            return true;

        return key > root.val ? search(root.right, key) : search(root.left, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void PrintRootToLeaf(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(path.toString());
        }
        PrintRootToLeaf(root.left, path);
        PrintRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return isValidBSTUtil(root, min, max);

    }

    public boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
    }

    int result = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        preOrderToFindSmallest(root, k);
        return result;
    }

    public void preOrderToFindSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        preOrderToFindSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        preOrderToFindSmallest(root.right, k);
    }

    public TreeNode mirrorBst(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftSubtree = mirrorBst(root.left);
        TreeNode rightSubtree = mirrorBst(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }

    public TreeNode createTreeFromSortedArray(int arr[], int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createTreeFromSortedArray(arr, left, mid - 1);
        root.right = createTreeFromSortedArray(arr, mid + 1, right);
        return root;
    }

    public void convertBSTtoBalancedBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        // Now convert the sorted list to a balanced BST
        TreeNode balancedRoot = createTreeFromSortedArray(list.stream().mapToInt(i -> i).toArray(), 0, list.size() - 1);
    }

    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        public Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public int maxBst;

    public Info largestBstInBt(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info leftInfo = largestBstInBt(root.left);
        Info rightInfo = largestBstInBt(root.right);

        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));

        if (root.val <= leftInfo.max || root.val >= rightInfo.min) {
            return new Info(size, min, max, false);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBst = Math.max(maxBst, size);
            return new Info(size, min, max, true);
        }
        return new Info(size, min, max, false);
    }

    public TreeNode mergeTwoBSTs(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        inOrder(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        inOrder(root2, list2);

        ArrayList<Integer> mergeList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergeList.add(list1.get(i));
                i++;
            } else {
                mergeList.add(list2.get(j));
                j++;
            }

            while (i < list1.size()) {
                mergeList.add(list1.get(i));
                i++;
            }
            while (j < list2.size()) {
                mergeList.add(list2.get(j));
                j++;
            }
        }
        TreeNode root = createTreeFromSortedArray(mergeList.stream().mapToInt(k -> k).toArray(), 0,
                mergeList.size() - 1);
        return root;
    }

}
