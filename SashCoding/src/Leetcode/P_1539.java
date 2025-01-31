package Leetcode;

public class P_1539 {
    public static void main(String[] args) {
int []arr = {2,3,4,7,11};
int k = 5;
        System.out.println("Answer : "+findKthPositive(arr,k));
    }
    public static int findKthPositive(int[] arr, int k) {
           int n=arr.length;
           int strt=0;
           int end=n-1;

           while(strt<=end){
               int mid=strt+(end-strt)/2;
               int miss=arr[mid]-(mid+1);
               if(miss<k){
                   strt=mid+1;
               }else{
                   end=mid-1;
               }
           }
    return end+1+k;
    }
}
