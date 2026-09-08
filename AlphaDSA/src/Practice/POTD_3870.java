package Practice;

import java.util.Scanner;

public class POTD_3870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Number of commas in " + n + " is: " + countCommas(n));
        // no of commas in range [1,n]
        int totalCommas = 0;
        for (int i = 1000; i <= n; i++) {
            totalCommas += countCommas(i);
        }
        System.out.println("Total number of commas in range [1," + n + "] is: " + totalCommas);
        sc.close();

    }

    public static int countCommas(int n) {
        int count = 0;
        while (n >= 1000) {
            count++;
            n /= 1000;
        }
        return count;
    }

}
