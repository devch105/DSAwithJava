package POTD.Jan.GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class Product_array_puszzle {
    public static int[] productExceptSelf(int arr[]) {
        int zeros=0;
        for(int c:arr){
            if(c==0){
                zeros++;
            }
        }
        int res[]=new int[arr.length];
        if(zeros>1){
            Arrays.fill(res,0);
            return res;
        } else if (zeros==0) {
            int totalpr=1;

            for (int c:arr){
                 totalpr*=c;
             }
            for(int i=0; i<arr.length; i++){
                int rem=totalpr/arr[i];
                res[i]=rem;
            }
        }else{
            Arrays.fill(res,0);
            int totalpr=1;
            for (int c:arr){
              if(c!=0){
                  totalpr*=c;
             }
           }
            for(int i=0; i<arr.length; i++){
                if(arr[i]==0){
                    res[i]=totalpr;
                }
            }
        }

     return res;
    }
    public static void main(String[] args) {
       int  arr[] = {12,0};
        System.out.println(productExceptSelf(arr));

    }
}
