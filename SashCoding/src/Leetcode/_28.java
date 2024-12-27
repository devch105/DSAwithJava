package Leetcode;

public class _28 {
    public static int strStr(String haystack, String needle) {


        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            if(haystack.charAt(i)==needle.charAt(i)){
                if (haystack.substring(i,needle.length()+i).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="sadbutsad";
        String b="but";
        System.out.println("Answer : "+strStr(s,b));


    }
}
