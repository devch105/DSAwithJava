package algorithimPatterns.TwoPointers;

public class Maximum_Subarray_P53 {
    static void main() {
        int nums[] = {-2};
        System.out.println("Maximum Subarray P(53): "+maxmimumSubarray(nums));

    }
    public static int maxmimumSubarray(int arr[]){
        int maxSum =Integer.MIN_VALUE;
        int currSum= 0;
        for(int i=0; i<arr.length; i++){
            currSum = Math.max(currSum+arr[i],arr[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
