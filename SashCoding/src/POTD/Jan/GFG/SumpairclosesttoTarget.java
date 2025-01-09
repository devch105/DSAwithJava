package POTD.Jan.GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumpairclosesttoTarget {

    public static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        List<Integer> list=new ArrayList<>();
        int strt=0;
        int end=arr.length-1,currclose=Integer.MAX_VALUE;

        while (strt<end){
            int sum=arr[strt]+arr[end];
            if(Math.abs(target-sum)<currclose){
                currclose=Math.abs(target-sum);
                list.clear();
                list.add(arr[strt]);
                list.add(arr[end]);
            }
            if(sum<target){
                strt++;
            } else {
                end--;
            }
        }
return  list;
    }

    public static void main(String[] args) {
       int  arr[] = {10, 30, 20, 5};
       int target = 25;
        System.out.println("Answer : "+sumClosest(arr,target));
    }
}
