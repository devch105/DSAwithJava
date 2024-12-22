package Recursion;

import java.util.Scanner;

public class PrintNatural_no {
    public  static void  printNumbers(int n){
        if(n>0){
            printNumbers(n-1);
            System.out.print(n+", ");

        }
    }


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number : ");
        int n=sc.nextInt();
        printNumbers(n);



    }
}
