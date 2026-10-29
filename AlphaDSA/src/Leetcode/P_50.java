import java.util.*;

public class P_50 {
    
    public static void main(String[] args) {
    // calculate pow of x,n
    // x = -100 t0 100
    // n = -2^31 to 2^31
    System.out.println("Answer :"+myPow(2.00, 4));
    }

    public static  double myPow(double x, int n) {
       
       if(n<0){
        n=-n;
        x=1/x;
       }
       
        double pow=1;
        while(n!=0){
            if((n&1) !=0){
                pow*=x;
            }
            x*=x;
            n>>>=1;
        }
        return pow ;
    }
}
