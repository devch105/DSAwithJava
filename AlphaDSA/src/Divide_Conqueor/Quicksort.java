package Divide_Conqueor;

import java.util.Arrays;

public class Quicksort {

    public static void quicksort(int arr[],int strt,int end){

        if(strt>=end){
            return;
        }

        // last element

        int pivot=partioning(arr,strt,end);
        quicksort(arr,strt,pivot-1);
        System.out.println("Answer : "+ Arrays.toString(arr));
        quicksort(arr,pivot+1,end);
    }

    public static int partioning(int arr[],int strt,int end){

        int pivot=arr[end];
        int i=strt-1;

        for(int j=strt; j<end; j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        //swap
        int temp=pivot;
        arr[end]=arr[i];
        arr[i]=temp;


        System.out.println("Answer : "+ Arrays.toString(arr));
        return i;

    }


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13};
        quicksort(arr,0, arr.length-1);
        System.out.println("Answer : "+ Arrays.toString(arr));
    }
}
