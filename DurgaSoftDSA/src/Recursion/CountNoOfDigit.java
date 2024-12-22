package Recursion;

import java.util.Scanner;

public class CountNoOfDigit {
    static int count =0;   // Static variable for maintaining count.0
    static int countdigits(int n){

        if(n!=0){
            count++;
            countdigits(n/10);}
            return (count==0)?1:count;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter digit : ");
        int len= sc.nextInt();
        System.out.println("Answer : "+countdigits(len));

    }
}
