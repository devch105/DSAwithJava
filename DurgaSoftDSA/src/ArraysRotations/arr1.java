package ArraysRotations;

import java.util.Arrays;

public class arr1 {

    static void printarray(int arr[]){
        System.out.println("=> "+ Arrays.toString(arr));
    }

    static void TempRotations(int arr[],int r){
        int temp=arr[0];
        r=r%arr.length ;
        for (int i=0; i< arr.length-1; i++ ){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=temp;
    }

    // Reversal Rotations Algorithim :
    static void reverse(int arr[],int s,int e){
        int temp;
        while (s<e){
            temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }

    static void reverse_Arrray(int a[],int rot){
        rot=rot%a.length;
        // Right
        reverse(a,0,rot-1);
        reverse(a,rot,a.length-1);
        reverse(a,0,a.length-1);   //left
        printarray(a);
    }


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
//        System.out.println("---Before Rotations---");
//        printarray(arr);
//        TempRotations(arr,1);
//        System.out.println();
//        System.out.println("---After Rotations----");
//        printarray(arr);


        reverse_Arrray(arr,2);
    }

}
