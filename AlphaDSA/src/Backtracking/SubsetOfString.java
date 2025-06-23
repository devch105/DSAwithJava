package Backtracking;

public class SubsetOfString {
    static void findSubset(String str,String ans , int i){
        // base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        // yes choice
        findSubset(str,ans+str.charAt(i),i+1);

        // No Choice
        findSubset(str,ans,i+1);
    }




    public static void main(String[] args) {
        String s="abc";
        findSubset(s,"",0);

    }
}
