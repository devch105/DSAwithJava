package Leetcode;

import java.util.Arrays;

public class P_1304 {
    public static int[] sumZero(int n) {
        int result[] = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n; i = i + 2) {
                result[i + 1]= i+1;
                result[i] = -(i + 1);

            }
        } else {
            for (int i = 0; i < n - 1; i = i + 2) {
                result[i] = i + 1;
                result[i + 1] = -(i + 1);
            }
            result[n - 1] = 0;
        }
        return result;
    }
    public static void main(String[] args) {
     int arr[]=sumZero(4);
        System.out.println("Answer : "+ Arrays.toString(arr));
    }
}
