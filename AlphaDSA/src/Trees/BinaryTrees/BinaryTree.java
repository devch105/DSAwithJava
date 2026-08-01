package Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int indx = -1;

    public static Node BuildTree(int nodes[]) {
        indx++;
        if (nodes[indx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[indx]);

        newNode.left = BuildTree(nodes);
        newNode.right = BuildTree(nodes);

        return newNode;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void PostOrder(Node root) {
        if (root == null) {
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void Levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) { // ✅ fixed condition
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static int HeightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = HeightOfTree(root.left);
        int rightHeight = HeightOfTree(root.right);

        int rootHeight = Math.max(leftHeight, rightHeight) + 1;

        return rootHeight;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        int totalCounts = leftCount + rightCount + 1;
        return totalCounts;
    }

    public static int SumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);

        int totalSum = leftSum + rightSum + root.data;

        return totalSum;
    }

    public static int DiameterO2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = DiameterO2(root.left);
        int leftHeight = HeightOfTree(root.left);
        int rightDiam = DiameterO2(root.right);
        int rightHeight = HeightOfTree(root.right);

        int selfDiam = leftHeight + rightHeight + 1;

        return Math.max(Math.max(rightDiam, leftDiam), selfDiam);
    }

    static class Info {
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    public static Info diameterOfTree(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOfTree(root.left);
        Info rightInfo = diameterOfTree(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diam, height);
    }

    public boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || subRoot.data != root.data) {
            return false;
        }

        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public boolean isSubTree(Node root, Node subRoot) {
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    static class Struct {
        Node root;
        int hd;

        public Struct(Node root, int hd) {
            this.hd = hd;
            this.root = root;
        }
    }

    public void topViewOfTree(Node root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Struct> q = new LinkedList<>();
        int min = 0, max = 0;
        q.add(new Struct(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Struct curr = q.remove();
            if (curr == null || curr.root == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.root);
                }

                if (curr.root.left != null) {
                    q.add(new Struct(curr.root.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.root.right != null) {
                    q.add(new Struct(curr.root.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

        }

        for (int i = min; i <= max; i++) {

            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public void kthLevelOfTree(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
        }

        kthLevelOfTree(root.left, level + 1, k);
        kthLevelOfTree(root.right, level + 1, k);
    }

    public Node lowestCommonAncestor(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lowestCommonAncestor(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor(root.right, n1, n2);

        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;

    }

    public int MinDistanceBetweenNodes(Node root, int n1, int n2) {
        // d1 = lca -> n1 d2 = lca -> n2
        Node lca = lowestCommonAncestor(root, n1, n2);
        int d1 = localDist(lca, n1);
        int d2 = localDist(lca, n2);
        return d1 + d2;
    }

    // helper function
    public int localDist(Node root, int n1) {
        if (root == null) {
            return -1;
        }

        if (root.data == n1) {
            return 0;
        }

        int leftDist = localDist(root.left, n1);
        int rightDist = localDist(root.right, n1);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public int KthAncestorofNode(Node root, int n1, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n1) {
            return 0;
        }

        int leftDist = KthAncestorofNode(root.left, n1, k);
        int rightDist = KthAncestorofNode(root.right, n1, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist) + 1;
        if (max == k) {
            System.out.println("Data : " + root.data);
        }
        return max;
    }

    public int transformSumOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = transformSumOfTree(root.left);
        int rightSum = transformSumOfTree(root.right);

        int temp = root.data;
        root.data = leftSum + rightSum;
        return leftSum + rightSum + temp;
    }

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public Node buildNodeFromPreOrderAndInOrder(int preOrder[], int inOrder[]) {
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        Node root = build(preOrder, 0, preOrder.length - 1);

        return root;

    }

    public Node build(int[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        Node root = new Node(preOrder[preIndex]);
        preIndex++;
        int pos = map.get(root.data);

        root.left = build(preOrder, left, pos - 1);
        root.right = build(preOrder, pos + 1, right);

        return root;

    }

    HashMap<Integer, Integer> postmap = new HashMap<>();
    int postIndex;

    public Node buildNodeFromPostOrderAndInOrder(int postOrder[], int inOrder[]) {
        for (int i = 0; i < inOrder.length; i++) {
            postmap.put(inOrder[i], i);
        }

        postIndex = postOrder.length - 1;

        Node root = postbuild(postOrder, 0, postOrder.length - 1);

        return root;

    }

    public Node postbuild(int[] postOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        Node root = new Node(postOrder[postIndex]);
        postIndex--;
        int pos = postmap.get(root.data);
        root.right = postbuild(postOrder, pos + 1, right);
        root.left = postbuild(postOrder, left, pos - 1);
        return root;
    }


    public static List<List<Integer>> ZigzagLevelorder(Node root) {
        if(root == null){
            return null;
        }
      
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> level = new ArrayList<>();

        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i<size; i++){
                Node curr = q.remove();

                ans.add(curr.data);

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

            if(!leftToRight){
                Collections.reverse(ans);
            }
            level.add(ans);
            leftToRight = !leftToRight;
        }
       return level;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        BinaryTree Btree = new BinaryTree();
        Node root = Btree.BuildTree(nodes);

        System.out.println("Preorder:");
        Btree.preOrder(root);

        System.out.println("\n Kth level of Tree");
        Btree.kthLevelOfTree(root, 1, 2);

        // System.out.println("\n lowest common ancestor : " +
        // Btree.lowestCommonAncestor(root, 4, 6).data);
        // System.out.println("\n Minimum Distance between Nodes : " +
        // Btree.MinDistanceBetweenNodes(root, 4, 6));

        // System.out.println("Kth ancestor of Node : " + Btree.KthAncestorofNode(root,
        // 6, 2));

        // System.out.println("\n Traverse \n");
        // Btree.Levelorder(root);

        // System.out.println("Transform sum of Tree : " +
        // Btree.transformSumOfTree(root));

        // System.out.println("\n Traverse \n");
        // Btree.Levelorder(root);

        // int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 },
        // postorder = {9,15,7,20,3};

        // Node newRoot = Btree.buildNodeFromPreOrderAndInOrder(preorder, inorder);

        // System.out.println("\n Traverse \n");
        // Btree.Levelorder(newRoot);

        // System.out.println(" \n Post and Inorder Tree formation \n");

        // Node postRoot = Btree.buildNodeFromPostOrderAndInOrder(postorder, inorder);

        // System.out.println("\n Traverse \n");
        // Btree.Levelorder(postRoot);

        System.out.println("\n Level Order Traversal \n");
        Btree.Levelorder(root);

        System.out.println("\n Zig Zag level Order Traversal \n");
        System.out.println(Btree.ZigzagLevelorder(root).toString());

    }
}
