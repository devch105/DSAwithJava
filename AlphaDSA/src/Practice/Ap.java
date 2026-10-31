package Practice;

import java.util.Scanner;

public class Ap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        int result  =   n*(n+1)/2;

        System.out.print("Answer : "+result);
    }
}
