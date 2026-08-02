package Leetcode;

public class P_1863 {
    // Backtracking and Recursion
static int sum=0;
    public  static  int subsetXORSum(int[] nums) {

return dfs(nums,0,0);

    }

    static int dfs(int nums[],int i, int xor){
        if(i>=nums.length)return xor;

        return dfs(nums,i+1, xor^nums[i]) +dfs(nums,i+1,xor);
    }



    public static void main(String[] args) {
        int nums[] = {5,1,6};
        int $s=9;
        System.out.println("Answer : "+subsetXORSum(nums));
    }
}
