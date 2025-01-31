package Recursion;

public class Tileplacing {
    public static void main(String[] args) {
        System.out.println("Answer : "+placetile(4));
    }

    private static int placetile( int n) {
        // base
        if(n==0 || n==1){
            return 1;
        }
        // kaam
        //verical
        int fnm1=placetile(n-1);

        //horizontal
        int fnm2=placetile(n-2);

        int ways=fnm1+fnm2;

        return ways;
    }
}
