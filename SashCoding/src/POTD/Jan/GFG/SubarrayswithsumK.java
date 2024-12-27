package POTD.Jan.GFG;

import java.util.HashMap;

public class SubarrayswithsumK {

    public static int countSubarrays(int arr[], int k) {
        // code here
        int sum=0,ans=0;
        int totalsum=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0; i<arr.length; i++){
           totalsum+=arr[i];
            if(hm.containsKey(totalsum)){

            }
        }

     return  totalsum;
    }
    public static void main(String[] args) {
     int [] arr=   {10, 2, -2, -20, 10};
     int k = -10;
    }
}
