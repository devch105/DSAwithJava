package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.Arrays;

public class SortZerosandOnesArray {

    public static void sortzeroandOnes(int arr[]){
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            while(arr[left]!=1){
                left++;
            }
            while(arr[right]!=0){
                right--;
            }
            if((arr[left]==1 & arr[right]==0)&left<right){
               int temp=arr[right];
               arr[right]=arr[left];
               arr[left]=temp;
               left++;
               right--;
            }
        }


        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        int arr[]={1,0,0,1,0,0,1,0,1};

        sortzeroandOnes(arr);
    }
}
