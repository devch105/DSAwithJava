package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
//    public static int[] nextGreater_BruteForce(int arr[]) {
//        int nxtGreat[] = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            nxtGreat[i] = -1; // Default to -1
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    nxtGreat[i] = arr[j];
//                    break; // Stop at first greater element
//                }
//            }
//        }
//        return nxtGreat;
//    }

    public static  int [] nxtgreat(int arr[]){
        int nextgrat[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        int end=arr.length-1;

        for(int i=end; i>=0; i--){
         // 1 . check stack and compare
               while (!s.isEmpty() && arr[s.peek()]<=arr[i] ){
                 s.pop();
              }
//               if-else empty
               if(s.isEmpty()){
                   nextgrat[i]=-1;
               }else {
                   nextgrat[i]=arr[s.peek()];
               }

//                Push next Element into Stack
               s.push(i);
        }
        return nextgrat;
    }




    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
    System.out.println("Answer : " + Arrays.toString(nxtgreat(arr)));
    }
}
