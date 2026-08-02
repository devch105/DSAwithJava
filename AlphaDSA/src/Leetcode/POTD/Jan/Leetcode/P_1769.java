package POTD.Jan.Leetcode;

import java.util.Arrays;

public class P_1769 {
    // Time => O(3n)
    // Space => O(3n)
    public static int[] minOperations(String boxes) {
      int left[]=new int[boxes.length()];
      int right[]=new int[boxes.length()];
      int res[]=new int[boxes.length()];
      left[0]=0;
      right[boxes.length()-1]=0;

      int count =boxes.charAt(0)-'0';
      // left
      for(int i=1; i<boxes.length(); i++){
           left[i]=left[i-1]+count;
           count+=boxes.charAt(i)-'0';
      }
      //Right
        count=boxes.charAt(boxes.length()-1)-'0';
      for(int i=boxes.length()-2; i>=0; i--){
          right[i]=right[i+1]+count;
          count+=boxes.charAt(i)-'0';
      }

      for(int i=0; i<boxes.length(); i++){
          res[i]=left[i]+right[i];
      }
      return res;
    }


    public static void main(String[] args) {
        String b="110";
        int arr[]=minOperations(b);
        System.out.println("Answer : "+ Arrays.toString(arr));
    }
}
