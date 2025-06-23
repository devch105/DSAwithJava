package Recursion;

public class BinaryStringsPrint {

    public static void main(String[] args) {

        printstrings(3
                ,0,"");
    }

    private static void printstrings(int n,int lp, String str) {
        if (n==0){
            System.out.println(str);
            return;
        }
        printstrings(n-1,0,str+"0");
        if(lp==0) {
            printstrings(n - 1, 1, str + "1");
        }

    }
}
