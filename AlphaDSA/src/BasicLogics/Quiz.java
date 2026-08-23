package BasicLogics;

public class Quiz {

    public static boolean checkprime(int n) {
        int fact = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                fact++;
            }
        }
        return (fact == 2) ? true : false;
    }

    public static void main(String[] args) {
        Integer x = 10;
        change(x++);
        System.out.println("X PostIncrement : " + x);
        change(++x);
        System.out.println("X PreIncrement : " + x);
    }

    public static int change(Integer x) {
        x++;
        System.out.println("X ->  : " + x);
        ++x;
        System.out.println("-> X : " + x);
        return x;
    }
}
