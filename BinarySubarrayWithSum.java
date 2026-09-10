/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;

/**
 *
 * @author predator
 */
public class BinarySubarrayWithSum {

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0};
        int goal = 0;
        System.out.println("Answer : "+countSubArrays(arr, goal));

        System.out.println("Answer : "+countSubarrays(arr, goal));
    }

    // Brute Force 
    public static int countSubArrays(int arr[], int goal){
        int count=0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum+=arr[j];
                if(sum==goal){
                    count++;
                }
            }
        }
        return  count;
    }

    public static int countSubarrays(int arr [], int k){
        int count=0;
        int currSum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int x : arr){
            currSum+=x;
            if(map.containsKey(currSum-k)){
                count += map.get(currSum-k);
            }

            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
