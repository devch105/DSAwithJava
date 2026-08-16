package DP;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Fibonacci : " + fib(n));

        int fM[] = new int[n + 1];
        System.out.println("----------------------------------");

        System.out.println(" Fib using Memoization : " + fibDpMemoization(n, fM));

        int fT[] = new int[n + 1];

        System.out.println("Fib using Tabulation : " + fibDpTabulation(n, fT));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            System.out.println("n : 0,1 =>> " + n);
            return n;
        }
        System.out.println("n : " + n);
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibDpMemoization(int n, int f[]) {
        if (n == 0 || n == 1) {
            System.out.println(" n: 0,1 ==> " + n);
            return n;
        }
        if (f[n] != 0) {
            System.out.println("n !=0,1 : " + f[n]);
            return f[n];
        }
        f[n] = fibDpMemoization(n - 1, f) + fibDpMemoization(n - 2, f);
        System.out.println("cal(f[n]) : " + f[n]);
        return f[n];
    }

    public static int fibDpTabulation(int n, int f[]) {
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
