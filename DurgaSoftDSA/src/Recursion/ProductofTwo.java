package Recursion;

import java.util.Scanner;

public class ProductofTwo {

    static int product(int a,int b){
        if(a<b){
            System.out.println("=>");
            return product(b,a);
        } else if (b!=0) {
            System.out.println("->");
            return a+product(a,b-1);
        }else
            System.out.println(">>");
        return 0;

    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter A : ");
        int a= sc.nextInt();
        System.out.println("Enter B : ");
        int b=sc.nextInt();

        System.out.println(" Answer : "+product(a,b));
    }
}
