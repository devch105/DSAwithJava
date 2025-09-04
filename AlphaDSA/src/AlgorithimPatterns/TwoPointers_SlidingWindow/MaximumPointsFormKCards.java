package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class MaximumPointsFormKCards {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int arr[]={6,2,3,4,7,2,1,7,1};
        int k =4;
        System.out.println("->"+MaxPointsFromCards(arr,k));

    }
    public static int MaxPointsFromCards(int arr[], int k){
        int lefftSum=0, rightSum=0,maxSum=0 ,n=arr.length-1;
        for(int i=0; i<=k-1; i++){
            lefftSum+=arr[i];
        }
        for( int i=k-1; i>=0; i--){
            lefftSum-=arr[i];
            rightSum+=arr[n];
            n--;
            maxSum=Math.max(maxSum,(lefftSum+rightSum));
        }
        return maxSum;
    }
}
