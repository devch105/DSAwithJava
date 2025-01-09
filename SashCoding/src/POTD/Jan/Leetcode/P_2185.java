package POTD.Jan.Leetcode;

public class P_2185 {
    public static int prefixCount(String[] words, String pref) {
        int count =0;
        int len= pref.length();
        for(String str:words){
            if(str.startsWith(pref)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
       String []words = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println("Answer :  "+prefixCount(words,pref));
    }
}
