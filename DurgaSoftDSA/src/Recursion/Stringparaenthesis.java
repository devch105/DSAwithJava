package Recursion;

public class Stringparaenthesis {
  static boolean check(String s,int i, int j)
  {
        if(i>j) return  true;
        if(s.charAt(i)=='(' && s.charAt(j)==')')return check(s,i+1,j-1);
         else return false;
  }

    public static void main(String[] args) {
        String s="(())()";
        System.out.println(" Answer : "+check(s,0,s.length()-1));
    }
}
