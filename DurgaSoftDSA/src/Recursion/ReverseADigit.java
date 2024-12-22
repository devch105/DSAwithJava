package Recursion;

import java.util.Scanner;

public class ReverseADigit {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter digit : ");
        String digit= sc.nextLine();
         int len= sc.nextInt();
        System.out.println(" Answer int1 : "+reverseNumber(len,0));
        System.out.println(" Answer : "+reverseofDigit(Integer.parseInt(digit),digit.length()));
    }

    private static int reverseofDigit(int digit, int len) {
        if (digit == 0) return 0;
        else return (int) (((digit%10)*Math.pow(10,len-1))+reverseofDigit((digit/10),--len));
    }
    static int reverseNumber(int digit, int reversed) {
        if (digit == 0) return reversed;
        reversed = reversed * 10 + (digit % 10);
        return reverseNumber(digit / 10, reversed);
    }
}
