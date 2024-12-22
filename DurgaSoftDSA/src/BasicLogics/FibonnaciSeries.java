package BasicLogics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonnaciSeries {

    public static void printfib(int n) {
        List<Integer> l1=new ArrayList<>();
        int a=0,b=1;
       int c;
        l1.add(a);
        l1.add(b);
       for(int i=1; i<n-2; i++){
           c=a+b;
           l1.add(c);
           a=b;
           b=c;
       }
        System.out.println(l1);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println(" Enter Number : ");
        int n =sc.nextInt();


        printfib(n);
    }
}
