package Sorting;

import java.util.Arrays;

public class SelectionSort {

    static  void Selectionsort(int arr[] ,int n){
         int i,j,min,tmp;
         for(i=0; i<n-1; i++){
             min=i;
             for (j=i+1; j<n; j++){
                 if(arr[j]<arr[min])
                     min=j;
             }
             if(min!=i){
                 tmp=arr[i];
                 arr[i]=arr[min];
                 arr[min]=tmp;
             }
         }
    }
    public static void main(String[] args) {
        int arr[]={1,9,3,8,7,5,2,4 };
        System.out.println("--Before Sorting--");
        System.out.println("=> "+ Arrays.toString(arr));
        System.out.println("----------------------");
        Selectionsort(arr,arr.length);
        System.out.println("=> "+ Arrays.toString(arr));




    }
}
