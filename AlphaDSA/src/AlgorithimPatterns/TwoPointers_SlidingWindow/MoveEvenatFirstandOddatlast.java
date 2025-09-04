package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.util.Arrays;

public class MoveEvenatFirstandOddatlast {

    public static void sortEvenandOdd(int arr[]){
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            while(arr[left]%2==0){
                left++;
            }
            while(arr[right]%2!=0){
                right--;
            }
            if((arr[left]%2!=0 & arr[right]%2==0)&left<right){
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
    int arr[]={21,12,13,24,60,31};
    sortEvenandOdd(arr);
    }
}
