package Sorting;

import java.util.Arrays;

public class InsertionSort {
    private static void insertionsort(int[] arr, int n) {
        int temp,j;
        for(int i=1; i<n; i++){
            temp=arr[i];
            j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;


        }
    }

    public static void main(String[] args) {
        int arr[]={5,4,10,2,3,6};
        System.out.println("--Before Sorting--");
        System.out.println("=> "+ Arrays.toString(arr));
        System.out.println("----------------------");
        insertionsort(arr,arr.length);
        System.out.println("=> "+ Arrays.toString(arr));

    }


}
