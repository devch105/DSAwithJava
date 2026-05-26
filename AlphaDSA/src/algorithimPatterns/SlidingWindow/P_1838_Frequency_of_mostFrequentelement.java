
package algorithimPatterns.SlidingWindow;
 
import java.util.Arrays;

public class P_1838_Frequency_of_mostFrequentelement {

    public static void main(String[] args) {
        
        int [] nums = {1,4,8,13};
        int k=5;
        System.out.println("Answer : "+maxFrequencySlidning(nums, k));
    }

    public static  int  maxFrequencySlidning(int [] nums , int k){
       Arrays.sort(nums);
        int left=0;
        long currSum=0;
        int result=-1;
        for(int right =0; right<nums.length; right++){
            currSum+=nums[right];

            long target = nums[right];
            long count = right-left+1;

            long windowSum = count*target;

            long ops = windowSum - currSum;

            while(ops>k){
                currSum-=nums[left];
                left++;
                ops = (right-left+1)*target-currSum;
            }

            result = Math.max(result,right-left+1);


        }
        return result;

    }


















    ///  
    /// SORTING +   BINARY SEARCH + PREFIX SUM 
    /// 

    public static int maxFrequency(int []nums, int k){
        int result = -1;
        Arrays.sort(nums);

        int preSum[]= new int [nums.length];

        preSum[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            preSum[i]=preSum[i-1]+nums[i];
        }

        for(int i=0; i<nums.length; i++){
            int freq = binarySearch(i,k,nums,preSum);
            result = Math.max(result,freq);
        }
        return result;
    }

    public static int binarySearch(int index, int k, int []nums , int [] preSum){
        int left=0;
        int right=index;
        int result=index;

        while(left<=right){
            int mid = left+(right-left)/2;

            int count = index-mid+1;
            int WindowSum= count*nums[index];
            int orgSum = preSumcompute(preSum, mid, index);
            
            int ops = WindowSum - orgSum;

            if(ops>k){
                left=mid+1;

            }else{
                result = mid;
                right=mid-1;
            }
        }

        return index-result+1;
    }

    public static int preSumcompute(int []nums,int left, int right){
        if(left==0)return nums[right];
        return nums[right]-nums[left-1];
    }
}
