package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int arr[]={2,5,1,7,10};
        int k=14;

        System.out.println("Answer : "+LongestSubarrayWithSum(arr,k));
    }

    public static int LongestSubarrayWithSum(int arr[], int k){
        int left=0;
        int right=0;

        int sum=0;
        int count=0;

        int n=arr.length;
        while(right<arr.length && left <=right){
            sum=sum+arr[right];

            if(sum>k  ){
                sum=sum-arr[left];
                left=left+1;
            }

            if(sum<=k){
                count=Math.max(count,right-left+1);
                right=right+1;
            }
        }

        return count;
    }
}
