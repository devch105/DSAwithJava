package BasicLogics;

import java.util.Scanner;

public class PrimeNumber {

    public static boolean checkprime(int n){
        int fact=0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                fact++;
            }
        }
        return (fact==2)?true:false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println(" Enter Number : ");
        int n =sc.nextInt();
        // logic 1 : Loop
        System.out.println("Is Number Prime :  "+checkprime(n));

        //logic 2: Recurision
        System.out.println("Is Number Prime :  "+checkprimeRec(n,n/2));
        // Print prime number in Range
        printallPrime(n);
    }

    private static boolean checkprimeRec(int n ,int i) {
        if(i==1)return true;
        else if (n%i==0){
            return false;
        }
        else return checkprimeRec(n,--i);
    }
    public static void printallPrime(int Range ){
    for(int i=2; i<=Range; i++){
        if(checkprimeRec(i,i/2)){
            System.out.println(i+"is Number Prime");
        }

    }
    }

}
