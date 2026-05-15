package AlgorithimPatterns.SlidingWindow;

import java.util.*;

public class SlidingWindowMaximum_P239 {
    static void main() {

        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
       // Output: [3,3,5,5,6,7]
        System.out.println("Answer : "+Arrays.toString(maxSlidingWindow(nums,k)));


    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n=nums.length;
        int result [] =  new int[n - k + 1];
                                                                //   ----------------------------------------------------------
        Deque<Integer> deque = new ArrayDeque<>();              //                   DEdQUEUE
                                                                //   ----------------------------------------------------------

        for(int i=0; i<n; i++){


            // Remove indcies out of current window
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }

            // Remove smaller element from back

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }

        }
        return result;
    }
}
