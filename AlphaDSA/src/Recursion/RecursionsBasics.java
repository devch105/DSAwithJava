package Recursion;

public class RecursionsBasics {
    static void printInc(int n){
        if(n==1){
            System.out.print(1+" |");
            return;
        }
        printInc(n-1);
        System.out.print(n+" |");
    }

    static void printDec(int n){
        if(n==1){
            System.out.print(1+" |");
            return;
        }
        System.out.print(n+" |");
        printDec(n-1);
    }

    public static void main(String[] args) {

        printDec(10);
        System.out.println("");
        printInc(10);
    }
}
