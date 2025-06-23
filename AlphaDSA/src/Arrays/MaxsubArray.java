package Arrays;

public class MaxsubArray {
// kadane Algorithims  O(n)
    static void maxSubArraySum(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            // Reset `currSum` if it becomes negative
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println(maxSum);
    }

    // Prefix Sum O(n+n^2)
    static void prefixmaxSubArraySum(int arr[]) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        // Compute prefix sum array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        // Find max subarray sum using prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subarraySum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, subarraySum);
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
    }

    static void prefixsumofSubArray(int arr[]){}

    public static void main(String[] args) {
        int arr1[]={4,5,6,-1,-4};
        maxSubArraySum(arr1);
    }
}
