package Backtracking;

import java.util.Arrays;

public class ChangeArray {
    static  void changearr(int arr[], int i, int val){
        // base:
        if(i==arr.length){
            System.out.println("Array :"+ Arrays.toString(arr));
            return;
        }
        // Recursion-> Work::
        arr[i]=val;
        changearr(arr,i+1,val+1);
        arr[i]=arr[i]-2;
    }


    public static void main(String[] args) {
        int arr[]=new int[5];
        changearr(arr,0,2);
        System.out.println("<--------->");
        System.out.println("Arrays:: "+Arrays.toString(arr));
    }
}
