package Recursion;

import java.util.Scanner;

public class FindNth_numberinFib {
              static int fibNth(int n){
                  if(n==0 || n==1){
                      return n;
                  }else{
                      return fibNth(n-1)+fibNth(n-2);
                  }
              }


       public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter A : ");
           int a= sc.nextInt();
           System.out.println("Answer : "+fibNth(a));
    }
}
