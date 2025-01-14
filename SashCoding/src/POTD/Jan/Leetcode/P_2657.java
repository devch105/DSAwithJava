package POTD.Jan.Leetcode;

import java.util.Arrays;

public class P_2657 {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
// find frequency
        int freq[]= new int[A.length+1];

        int c[]=new int[A.length];
        int count=0;
        for(int i=0; i<A.length; i++){
            freq[A[i]]++;
            if(freq[A[i]]==2)count++;

            freq[B[i]]++;
            if(freq[B[i]]==2)count++;

            c[i]=count;
        }
        return c;
    }

    public static void main(String[] args) {
      int []  A = {1,3,2,4}, B = {3,1,2,4};
      int x[]=findThePrefixCommonArray(A,B);
        System.out.println("Answer : "+ Arrays.toString(x));
    }
}
