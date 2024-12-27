package Sorting;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int arr[]={5,4,10,2,3,6};
        System.out.println("--Before Sorting--");
        System.out.println("=> "+ Arrays.toString(arr));
        System.out.println("----------------------");
        quicksort(arr,0,arr.length-1);
        System.out.println("=> "+ Arrays.toString(arr)); // wrong


    }

    private static void quicksort(int[] arr, int li ,int ri) {
        if(li>=ri) return;
        int pivt,lp,rp,tmp;

        pivt=arr[ri];
        lp=li;
        rp=ri-1;

        while (lp<rp){
            while (arr[lp]<=pivt && lp<rp){
                lp++;
            }
            while (arr[rp]>=pivt && lp<rp){
                rp--;
            }
            tmp=arr[lp];
            arr[lp]=arr[rp];
            arr[rp]=tmp;
        }
        tmp=arr[lp];
        arr[lp]=arr[ri];
        arr[ri]=tmp;

        quicksort(arr ,li,lp-1);
        quicksort(arr,lp+1,ri);


    }
}
