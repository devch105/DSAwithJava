package algorithimPatterns.SlidingWindow;

public class P_1248_CountAllNiceArray {

    public static  void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        System.out.println("Answer : "+(atMost(nums, k)-atMost(nums, k-1)));
        makeBinaryArray(nums);
        System.out.println(countNicePairs(nums, k)-countNicePairs(nums, k-1));
    }

    public static void makeBinaryArray(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                nums[i]=1;
            }else{
                nums[i]=0;
            }
        }
    }


    public static int countNicePairs(int[] nums, int k) {
        int left =0,right =0;
        int countSubArray = 0;
        int sum=0;
       
        // forming binarry array
    
       while(right<nums.length){
        sum+=nums[right];
          while(sum>k){
            sum-=nums[left];
            left++;
         }
         countSubArray+= right-left+1;
         right++;
        }
      
         return countSubArray;
    }

    public static int atMost(int arr[], int k){
        int res =0;
        int left =0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2!=0){
                k--;
            }

            while(k<0){
                if(arr[left]%2!=0){
                    k++;
                }
                left++;
            }

            res+=(i-left+1);
        }
        return res;
    }

}
       
    

