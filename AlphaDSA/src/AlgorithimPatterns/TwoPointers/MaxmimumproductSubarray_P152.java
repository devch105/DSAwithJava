package AlgorithimPatterns.TwoPointers;

public class MaxmimumproductSubarray_P152 {
    static void main() {
        int arr[] = {2,3,-2,-5,6,-1,4};
        System.out.println("Maximum Subarray P152 : "+maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            /* If  prefix or suffix become 0 then alter it to 1*/
           if(prefix == 0){prefix = 1;}
           if(suffix == 0){suffix = 1;}

           prefix *= nums[i];                             //  [i]      =>  0, 1, 2, 3, 4, 5, 6
           suffix *= nums[n-i-1];                         // [n-1-i]   =>  6, 5, 4, 3, 2, 1, 0

           max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
}
