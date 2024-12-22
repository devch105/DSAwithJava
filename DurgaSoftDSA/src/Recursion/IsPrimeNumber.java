package Recursion;

import java.util.Scanner;

public class IsPrimeNumber {

    static boolean isprimechecker(int n,int i){
        if(i==1){
            return true;
        } else if (n%i!=0) {
            return isprimechecker(n,--i);
        }

     return false;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number : ");
        int n=sc.nextInt();
        for(int i=2; i<=n; i++){
            System.out.println(" Is "+i+" A Prime : "+isprimechecker(i,i/2));
        }


    }
}
