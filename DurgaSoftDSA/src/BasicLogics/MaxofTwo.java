package BasicLogics;

public class MaxofTwo {
    public static void main(String[] args) {

        int  a=73;
        int b=34;
        // Logic 1: manaual
        System.out.println(" Greater : "+ Max1(a,b));
        // logiv 2 Math
        System.out.println(" Greater : "+Max2(a,b));
    }

    private static int Max1(int a, int b) {
        return (a>b)? a:b;
    }
    private  static int Max2(int a,int b){
       return Math.max(a,b);
    }
}
