package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int arr[]={-4,-1,-1,0,1,2};
        System.out.println("Answer : "+ThreeSumClosestVal(arr,4));
    }

    public static int ThreeSumClosestVal(int arr[] ,int target){
        int sum=0;
        int result=0;
        int resultSum=arr[0]+arr[1]+arr[2];
        int minDiff=Integer.MAX_VALUE;

        for(int i =0; i<arr.length; i++ ){
            int left=i+1;
            int right=arr.length-1;

            while (left<right){
                sum=arr[i]+arr[left]+arr[right];

                if(sum==target){
                    return target;

                }
                if(sum<target){
                    left++;
                }else {
                    right--;
                }


                int absoluteDiff=Math.abs(sum-target);

                if(absoluteDiff<minDiff){
                    resultSum=sum;
                    minDiff=absoluteDiff;
                }
            }
        }
        return resultSum;
    }

}
