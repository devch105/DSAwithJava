package Recursion;

public class Fibonacci {
    static int Fib(int n){
        if(n==0 || n==1){
            return n;
        }
        System.out.println(n);
        return Fib(n-1)+Fib(n-2);
    }

    public static void main(String[] args) {

        System.out.println("Answer : "+Fib(5));
    }
}
