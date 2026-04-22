package AlgorithimPatterns.TwoPointers_SlidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptItself {
    static void main() {
     int arr[]={3,4,6,1,2};
     productOfArrayExceptItself(arr);
    }

    public static void productOfArrayExceptItself(int arr[]){

        int leftProd [] = new int[arr.length];
        int rightProd [] = new int[arr.length];

        leftProd[0]=1;
        rightProd[arr.length-1]=1;

        for(int i=1; i<arr.length; i++){
            leftProd[i]=leftProd[i-1]*arr[i-1];
        }
        System.out.println("Left product : "+Arrays.toString(leftProd));


        for(int i=arr.length-2; i>=0; i--){
            rightProd[i]=rightProd[i+1]*arr[i+1];
        }

        System.out.println("Right Product : "+ Arrays.toString(rightProd));

        for(int i=0; i<arr.length; i++){
            arr[i]=leftProd[i]*rightProd[i];
        }
        System.out.println("Answer : "+Arrays.toString(arr));
    }
}
