package POTD.Jan.GFG;

import java.util.Arrays;

public class Countpairlessthantarget {
  static  int countPairs(int arr[], int target) {
        // Your code here
      Arrays.sort(arr);
      int strt=0;
      int end=arr.length-1;
      int sum=0;
      int count=0;
      while (strt<end){
          sum=arr[strt]+arr[end];
          if(sum<target){
              count+=end-strt;
              strt++;
          }else {
              end--;
          }
      }
      return count;
    }
    public static void main(String[] args) {
       int arr[] = {2, 1, 8, 3, 4, 7, 6, 5};
       int target = 7;
        System.out.println("Answer : "+countPairs(arr,target));
    }


}
