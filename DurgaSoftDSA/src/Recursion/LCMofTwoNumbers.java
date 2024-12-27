package Recursion;

import java.util.Scanner;

public class LCMofTwoNumbers {
    //static int lcm=1;

//    public static int findLcM(int a,int b,int lcm){
//      if(lcm%a==0 && lcm%b==0) return lcm;
//      lcm++;
//      findLcM(a,b,lcm+1);
//      return lcm;
//    }
public static int findLcM(int a, int b, int currentLcm) {
    if (currentLcm % a == 0 && currentLcm % b == 0) return currentLcm;
    return findLcM(a, b, currentLcm + 1); // Return the recursive result
}

public static  int HCF(int a,int b){
    while(a!=b){
        if(a>b)return HCF(a-b,b);
        else return HCF(a,b-a);
    }
    return a;
}


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1. ");
        int n=sc.nextInt();
        System.out.println("Enter 2.  ");
        int m= sc.nextInt();
        System.out.println(" Answer : "+findLcM(n,m,1));
        System.out.println(" Answer : "+HCF(n,m));

    }
}
