package algorithimPatterns.SlidingWindow;

import java.util.*;

public class SlidingWindowMaximum_P239 {

   public static void main( String args[]) {

        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
       // Output: [3,3,5,5,6,7]

       Deque<Integer> dq= new ArrayDeque<>();

       // add first 
       dq.addFirst(20);
       dq.addFirst(10);
       System.out.println(dq);
       // add last
       dq.addLast(30);
       dq.addLast(40);
       System.out.println(dq);
       // add at front and return true/false
       System.out.println("offer first : "+dq.offerFirst(5)+" update dq : "+dq);
       System.out.println("Offer Last : "+dq.offerLast(50)+" update dq : "+dq);

       System.out.println("remove first : "+dq.removeFirst());   // does not handle empty
       System.out.println("remove last : "+dq.removeLast());    // does not handle empty

       System.out.println("Poll First : "+dq.pollFirst());
       System.out.println("Poll Last : "+dq.pollLast());

       System.out.println("Peek First : "+dq.peekFirst());
       System.out.println("Peek Last : "+dq.peekLast());

      //  System.out.println("Answer : "+Arrays.toString(maxSlidingWindow(nums,k)));
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
