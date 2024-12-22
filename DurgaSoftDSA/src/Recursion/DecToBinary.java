package Recursion;

import java.util.Scanner;

public class DecToBinary {



    static int DecToBinaryConversion(int n){
        if(n==0) {return 0;}
        int x=DecToBinaryConversion(n/2);
        return (n%2+10*x);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter Digit : ");
        int n=sc.nextInt();
        System.out.println("Answer : "+DecToBinaryConversion(n));

    }
}
