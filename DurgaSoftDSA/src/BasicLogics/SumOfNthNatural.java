package BasicLogics;

import java.util.Scanner;

public class SumOfNthNatural {

    /*
    *  Sum of Elements in array using Recursion
    * */

    public static  int RecsrionSumArray(int a[],int n){

        if(n<0){
            return 0;
        }
        else return RecsrionSumArray(a,n-2)+a[n-1];

    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println(" Enter Number : ");
//        int n= sc.nextInt();
//
////        // Logic 1 : LOOP
////        System.out.println(" Sum Loop :  "+sumLoop(n));
////        System.out.println("----------------------------------");
////        // Logic 2: Recurison
////        System.out.println("Sum Recursion : "+sumRecursion(n));
////        System.out.println("-------------------------------");
////        // Logic 3 : Formula
////        System.out.println(" Sum Formula : "+sumFormula(n));
////        // Sum of Array using Recursion

        int arr[]={1,2,3,4,5,6,7,8,9,10}  ;
        int n= arr.length-1;
        System.out.println(" Answer : "+RecsrionSumArray(arr,n));
    }

    private static int sumFormula(int n) {
        return (n*(n+1)/2);
    }

    private static int  sumRecursion(int n) {
        if(n==0){
            return 0;
        }else
            return n+sumRecursion(n-1);

    }

    private static int  sumLoop(int n) {

       int sum=0;
       for(int i=1; i<=n; i++){
            sum+=i;
        }
       return sum;
    }
}
