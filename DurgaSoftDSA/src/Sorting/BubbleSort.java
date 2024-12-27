package Sorting;

import java.util.Arrays;

public class BubbleSort {

    static void BubbleSort(int arr[]){
        int temp;
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                   temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }

        System.out.println("Answer => "+ Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[]={1,9,3,8,7,5,2,4 };
        System.out.println("before sorting ");
        System.out.println("--------------------- ");
        System.out.println(Arrays.toString(arr));
           BubbleSort(arr);

    }
}
