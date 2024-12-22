package Recursion;

import java.util.Scanner;

public class ApowerB {
    static int powerFunction(int a,int b){
        if(b!=0){
            return a*powerFunction(a,b-1);
        }else
            return 1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter A : ");
        int a= sc.nextInt();
        System.out.println("Enter B : ");
        int b=sc.nextInt();
        System.out.println(" Answer : "+powerFunction(a,b));

    }
}
