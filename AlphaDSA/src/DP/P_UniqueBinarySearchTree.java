package DP;

public class P_UniqueBinarySearchTree {
    // Problem: https://leetcode.com/problems/unique-binary-search-trees/

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Total unique BSTs for n = " + n + " is : " + NumTrees(n));
    }

    public static int NumTrees(int n) {
        return 1;
    }
}
