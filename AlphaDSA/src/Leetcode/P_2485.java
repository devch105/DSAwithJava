package Leetcode;

public class P_2485 {
    public static int pivotInteger(int n) {
        int totalSum=0;
        for(int i=1; i<=n; i++){
            totalSum+=i;
        }
        int currSum=0;
        for(int i=1; i<=n; i++){
            currSum+=i;
           totalSum-=(i-1);
           if(currSum==totalSum){
               return i;
           }
        }
        return -1;
    }
    public static void main(String[] args) {

        int n=8;
        System.out.println("Answer :"+pivotInteger(n));

    }
}
