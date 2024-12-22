package BasicLogics;

import java.util.Scanner;

public class Factoriallogic {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println(" Enter Number : ");
        int n =sc.nextInt();

        //Logic 1: Loop
        System.out.println(" Answer : "+Factorial(n));
        System.out.println(" -----------------------");
        System.out.println(" Answer Recursion : "+FactorialREC(n));
    }

    private static int  FactorialREC(int n) {
        if(n<0){
            System.out.println(" negative number not accepted");
            return -1;
        }
        if(n==0){
            return 1;
        }else{
            return n*FactorialREC(n-1);
        }
    }

    private static int Factorial(int n) {
        if(n<0){
            System.out.println(" negative number not accepted");
            return -1;
        }
        int fact=1;
        for(int i=n; i>=1; i--){
            fact*=i;
        }
        return fact;
    }
}
