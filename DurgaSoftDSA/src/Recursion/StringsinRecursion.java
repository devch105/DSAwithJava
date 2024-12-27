package Recursion;

import java.util.Scanner;

public class StringsinRecursion {


    static String strrev(String s){
        if(s==null || s.length()<=1)
            return s;
        return strrev(s.substring(1))+s.charAt(0);
    }


    static  String removeStr_Char(String s,int index){
         if(index==0)return "";
         if(s.charAt(index)=='x')return removeStr_Char(s,index-1);
         else return removeStr_Char(s,index-1)+s.charAt(index);
    }

    static String AddStr(String s,int n){
        if(n<1)
            return s.charAt(n)+"" ;
        return  AddStr(s,n-1)+"*"+s.charAt(n);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String : ");
        String s=sc.nextLine();
        System.out.println("Answer : "+strrev(s));
        System.out.println("--------------");
       //
        // System.out.println("Answer : "+removeStr_Char(s,3));
        System.out.println("=> "+AddStr(s,s.length()-1));


    }
}
