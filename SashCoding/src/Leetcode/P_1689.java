package Leetcode;

public class P_1689 {
    public static void main(String[] args) {
        String n="732";
        System.out.println("Answer "+minPartitions(n));

    }
    public static int minPartitions(String n) {
        int ans=0;
        char [] z=n.toCharArray();
        for(char x:z){
            // 0 -> 9
            // 48 -> 57
            int curr= x-48;
            ans=Math.max(curr,ans);
        }
        return ans;
    }
}
