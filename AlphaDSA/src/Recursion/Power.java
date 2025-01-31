package Recursion;

public class Power {
    static int power(int x,int n){
        if(n==1)return x;
        System.out.println(n+"-->");
        return x*power(x,n-1);
    }

    static int OptimizePower(int x,int n){
        if (n==0)return 1;
        int midproduct=OptimizePower(x,n/2);
      int halfPow=midproduct*midproduct;
        // case 1 : n==> Even
       if(n%2!=0) {
           halfPow=x*halfPow;
           return halfPow;
       }
        // case 2 : n==> Odd
       return halfPow;
    }

    public static void main(String[] args) {
        System.out.println("Answer : "+power(2,26));
        System.out.println("-++++++++++++++++++++++-");
        System.out.println("Answer : "+OptimizePower(2,26));
    }
}
