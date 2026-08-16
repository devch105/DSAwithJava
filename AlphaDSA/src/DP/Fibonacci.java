package DP;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Fibonacci : " + fib(n));

        int f[] = new int[n + 1];
        System.out.println("----------------------------------");

        System.out.println(" Fib DP : " + fibDp(n, f));

      
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            System.out.println("n : 0,1 =>> " + n);
            return n;
        }
        System.out.println("n : " + n);
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibDp(int n, int f[]) {
        if (n == 0 || n == 1) {
            System.out.println(" n: 0,1 ==> " + n);
            return n;
        }
        if (f[n] != 0) {
            System.out.println("n !=0,1 : " + f[n]);
            return f[n];
        }
        f[n] = fibDp(n - 1, f) + fibDp(n - 2, f);
        System.out.println("cal(f[n]) : " + f[n]);
        return f[n];
    }

   
}
