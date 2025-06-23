package Backtracking;

public class FindAllPermutations {

    static void stringpermutations(String str,String ans){
        // base
        if(str.length()==0){
            System.out.println("->"+ans);
            return;
        }
        // recursion

        for(int i=0; i<str.length(); i++){
            char curr=str.charAt(i);
            String nstr=str.substring(0,i)+str.substring(i+1);
            stringpermutations(nstr,ans+curr);
        }
    }
    public static void main(String[] args) {
        stringpermutations("abc","");

    }
}
