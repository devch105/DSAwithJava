package algorithimPatterns.TwoPointers;

import java.util.Arrays;

public class TwoSum_2_P167 {
    static void main() {
        int [] numbers = {2,7,11,15};
        int target = 9;

        System.out.println("Answer : "+ Arrays.toString(twoSum(numbers,target)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[] {left+1,right+1};
            } else if (sum>target) {
                right--;
            }else{
                left++;
            }
        }
        return new int[] {-1,-1};
    }


}
