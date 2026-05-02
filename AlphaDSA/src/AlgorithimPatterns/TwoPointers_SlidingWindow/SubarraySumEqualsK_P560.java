package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.HashMap;

public class SubarraySumEqualsK_P560 {
    static void main() {
        int arr [] ={1,2,3,4,5,1,2,3};
        int k = 5;
        System.out.println("Answer : "+subarraySum(arr,k));

    }
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
