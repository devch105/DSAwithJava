package BasicLogics;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter Number : ");
        int a=sc.nextInt();

        //logic 1: Simple conditional
        System.out.println(" Given Number is :  "+evenOrodd1(a));

        // Logic 2: Bitwise
        System.out.println(" Given Number is : "+Evenodd2(a));

    }

    private static String Evenodd2(int a) {
        return ((a&1)==1)?"Odd":"Even";
    }

    private static String evenOrodd1(int a) {
        return (a%2==0)? "Even":"Odd";
    }
}
