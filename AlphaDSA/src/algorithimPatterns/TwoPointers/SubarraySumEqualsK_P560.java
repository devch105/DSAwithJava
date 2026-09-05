package algorithimPatterns.TwoPointers;

import java.util.HashMap;

public class SubarraySumEqualsK_P560 {
    static void main() {
        int arr [] ={1,2,3,4,5,1,2,3};
        int k = 5;
        System.out.println("Answer : "+subarraySum(arr,k));
        System.out.println("Brute Force : "+brute(arr, k));

    }
    // Brute Force
    public static int brute(int nums[], int k){
        int count=0;
        for(int i=0; i<nums.length; i++){
            int sum =0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
            if(sum==k)count++; 
            }
        }
        return count;
    }

    // PrefixSum + HashMap

      public int sumEqualsK(int nums[], int k){
        int count=0;

        // calculate prefix
        int prefix [] = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<prefix.length; i++){
             
            if(prefix[i]==k){
                count++;
            }

            int val = prefix[i]-k;
            if(map.containsKey(val)){
                count +=map.get(val);
            }
            
                map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
            }
        return count;
    }

    // Prefix Variable  + HashMap

    public  static int subarraySum(int nums[],int k  ) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){

            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

                map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return count;
    }

   
}
