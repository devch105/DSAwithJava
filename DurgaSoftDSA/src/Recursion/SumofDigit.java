package Recursion;

import java.util.Scanner;

public class SumofDigit {

    static int sumofDigit(int Digit){
        if(Digit==0){
            return 0;
        }else
            return (Digit%10)+sumofDigit(Digit/10);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter digit : ");
        int digit =sc.nextInt();
        System.out.println(" sum of Digit "+digit+"is : "+sumofDigit(digit));

    }
}
