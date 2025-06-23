package Divide_Conqueor;

import java.util.Arrays;

public class Mergesort {

    public static void mergesort(int arr[],int strt,int end){
        // kaam

        if(strt>=end){
            return;
        }
        int mid=strt+(end-strt)/2;

        mergesort(arr,strt,mid);
        mergesort(arr,mid+1,end);
        merging(arr,strt,mid,end);
    }
    public static void merging(int arr[],int strt,int mid,int end){
        int temp[]=new int[end-strt+1];
        int i=strt;
        int j=mid+1;
        int k=0;

        while (i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        // left
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        // right
        while (j<= end){
            temp[k++]=arr[j++];
        }
        //copying
        for(int l=0; l<temp.length; l++){
            arr[strt+l]=temp[l];
        }
    }




    public static void main(String[] args) {
  int arr[]={34,21,29,12,9,4,3};
        mergesort(arr,0,arr.length-1);
        for(int x:arr){
            System.out.print(x+",");
        }
    }
}
