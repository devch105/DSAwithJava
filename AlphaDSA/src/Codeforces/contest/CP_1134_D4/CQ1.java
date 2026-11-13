package Codeforces.contest.CP_1134_D4;

import java.util.Arrays;
import java.util.Scanner;

public class CQ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (check(a, b, c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(int a, int b, int c) {
        int arr[] = { a, b, c };
        Arrays.sort(arr);
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
