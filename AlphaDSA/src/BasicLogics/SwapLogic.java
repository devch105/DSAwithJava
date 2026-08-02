package BasicLogics;

public class SwapLogic {


    public static void main(String[] args) {

         int a=34;
         int b=-67;
         //Logic 1 : Thrid Variable
        Swap1(a,b);
        System.out.println("------------------------");
        //logic 2 :  Addition and Subtraction
        Swap2(a,b);
        System.out.println("------------------------");
        // logic 3 : multiplication and division
        Swap3(a,b);
        System.out.println("------------------------ ");
        // logic 4 : Bitwise
        Swap4(a,b);
        // Logic 5 : Single Line
        System.out.println("--------------------");
        Swap5(a,b);

    }

    private static void Swap5(int a, int b) {
        System.out.println("before => A "+a+" B : "+b);

        a=(a+b)-(b=a);
        System.out.println("before => A "+a+" B : "+b);

    }

    private static void Swap4(int a, int b) {
        System.out.println("before => A "+a+" B : "+b);
        a=a^b;
        b=a^b;
        b=a^b;
        System.out.println("After => A "+a+" B : "+b);

    }

    private static void Swap3(int a, int b) {
        System.out.println( "Before Swap => A : "+a+" B : "+b);
        a=a*b;
        b=a/b;
        a=a/b;
        System.out.println( "After Swap => A : "+a+" B : "+b);
    }

    private static void Swap2(int a, int b) {
        System.out.println( "Before Swap => A : "+a+" B : "+b);
        a= a+b; // a= 2+1 => 3
        b=a-b;  //  b= 3-1 => 2
        a= a-b; //  a=3-2 = 1
        System.out.println( "After Swap => A : "+a+" B : "+b);
    }

    public static void Swap1(int a,int b){
        System.out.println( "Before Swap => A : "+a+" B : "+b);
        int temp;
        temp=a;
        a=b;
        b=temp;

        System.out.println( "After Swap =>  A : "+a+" B : "+b);
    }


}
