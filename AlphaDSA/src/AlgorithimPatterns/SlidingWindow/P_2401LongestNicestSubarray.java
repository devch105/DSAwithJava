package AlgorithimPatterns.SlidingWindow;

public class P_2401LongestNicestSubarray {
    public static void main(String[] args) {
        System.out.println("Answer : "+longestNiceSubarray(new int[]{1,3,8,48,10}));    
    }

     public static int longestNiceSubarray(int[] nums) {
        int left=0;
        int right=0;
        int max=0;
        int mask=0;

        while(right<nums.length){
            if((nums[right] & mask) ==0){
                mask |= nums[right];
                right++;
            }else{
                mask^=nums[left];
                left++;
            }
            max=Math.max(max, right-left);
            System.out.println("Max : "+max);
        }
        return max;
    }
}
