package Recursion;

import java.util.Scanner;

public class SumofNatural_no {

    static  int sumofnaturalnumber(int n){
        if(n>0){
            if(n==1){
                return 1;
            }
            else return n+sumofnaturalnumber(n-1);
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number : ");
        int n=sc.nextInt();
        System.out.println("Answer :"+sumofnaturalnumber(n));
    }
}
