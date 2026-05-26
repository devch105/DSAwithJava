package algorithimPatterns.TwoPointers;

import java.util.HashMap;

public class TwoSum {
    static void main() {
        int arr[] ={2,7,11,15};
        int target = 9;
        System.out.println("Amswer : "+twoSum(arr,target));
    }

    public  static  int [] twoSum(int arr[] , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int compliment = target - arr[i];

            // this is main condtion if match and compliment is not pointing itself
            if(map.containsKey(compliment) && map.get(compliment)!=i){
                return new int[] {i, map.get(compliment)};  // return sol
            }else{
                map.put(arr[i],i); // add map
            }
        }
        return null;
    }
}
