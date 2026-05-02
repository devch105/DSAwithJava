package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class Maximum_Subarray_P53 {
    static void main() {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Subarray P(53): "+maxmimumSubarray(nums));

    }
    public static int maxmimumSubarray(int arr[]){
        int maxSum =0;
        int currSum= 0;
        for(int i=0; i<arr.length; i++){
            currSum = Math.max(currSum+arr[i],arr[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
