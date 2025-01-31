package Leetcode;

import java.util.Arrays;

public class P_189 {
    static void reverse(int arr[], int s, int e) {
        int temp;
        while (s < e) {
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static int[] rotate(int a[], int rot) {
        rot = rot % a.length; // Handle rotations larger than the array size
        if (rot < 0) rot += a.length; // Handle negative rotations

        // Step 1: Reverse the entire array
        reverse(a, 0, a.length - 1);

        // Step 2: Reverse the first 'rot' elements
        reverse(a, 0, rot - 1);

        // Step 3: Reverse the remaining elements
        reverse(a, rot, a.length - 1);

        return a;
    }

    public static void main(String[] args) {
        int A[] = {-1, -100, 3, 99};
        int arr[] = rotate(A, 2);
        System.out.println("Answer: " + Arrays.toString(arr));
    }
}
