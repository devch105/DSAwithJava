package BasicLogics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trifibonnaci {
    public static void printTrifibonnaciSeries(int n){
        int a=0,b=1,c=2;
        List<Integer> l1=new ArrayList<>();
        l1.add(a);
        l1.add(b);
        l1.add(c);
        int t;
        for(int i=1;i<n-3; i++){
            t=a+b+c;
            l1.add(t);
            a=b;
            b=c;
            c=t;
        }

        System.out.println(l1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter Range : ");
        int n=sc.nextInt();
        printTrifibonnaciSeries(n);
    }
}
