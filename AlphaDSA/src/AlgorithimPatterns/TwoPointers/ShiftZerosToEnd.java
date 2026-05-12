package AlgorithimPatterns.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class ShiftZerosToEnd {
    static void main() {
        System.out.print("Enter Array Size : ");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr []= new int[n];

        System.out.println("Enter Array Elements");

        for(int i=0; i<n; i++){
            System.out.println("Enter Element "+(i+1)+" : ");
            arr[i]=sc.nextInt();
        }

        System.out.println("Array : "+ Arrays.toString(arr));
        System.out.println("Answer : "+Arrays.toString(shiftZerosToRight(arr)));
        System.out.println("Answer with Order : "+Arrays.toString(shiftZerostoRightwithOrder(arr)));
    }

    // Approach 1 order not maintain
    public static int [] shiftZerosToRight(int arr []){
        int left =0, right = arr.length-1;
        while(left<right){
            if(arr[left]==0 && arr[right]!=0){
                swap(arr, left, right);
                left++;
                right--;
            } else if (arr[left]!=0) {
                left++;
            }else {
                right--;
            }

        }
        return arr;
    }

    // Approach 2 Order maintain
    public static int[] shiftZerostoRightwithOrder(int arr[]) {
        int left = 0, right = 0;

        // Move all non-zero elements forward
        while (right < arr.length) {
            if (arr[right] != 0) {
                arr[left] = arr[right];
                left++;
            }
            right++;
        }

        // Fill remaining positions with 0
        while (left < arr.length) {
            arr[left] = 0;
            left++;
        }

        return arr;
    }



    public static void swap(int arr[], int left , int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
