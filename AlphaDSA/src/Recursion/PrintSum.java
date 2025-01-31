package Recursion;

public class PrintSum {
   static int printsum(int n){
       if (n==1)return 1;
       return printsum(n-1)+n;
   }

    public static void main(String[] args) {
        System.out.println("Answer : "+printsum(5));
    }
}
