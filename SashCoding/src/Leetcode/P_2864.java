package Leetcode;

import java.util.Arrays;

public class P_2864 {

    // Build a Maximum Odd Number from a binary String ?
/*
*  1. -> Sort Array
* -> 01100110 -> 00001111
*   Max Odd Number --> 11100001
*
*  */

    // O(Logn + n)
    public  static String maximumOdd_LogN(String s) {
        char [] str=s.toCharArray();
        Arrays.sort(str);
        int strt=0;
        int end=str.length-2;

        while (strt<=end){
            char temp=str[end];
            str[end]=str[strt];
            str[strt]=temp;
            strt++;
            end--;
        }
        return str.toString();
    }

    public  static String maximumOdd_Optmize_N(String s) {
        char [] str=s.toCharArray();
        int strt=0;
        int end=s.length()-1;
        while (strt<=end){
            if(strt<end && str[strt]=='0' && str[end]=='1'){
                str[strt]='1';
                str[end]='0';
            }
            if(str[strt]=='1')strt++;
            if(str[end]=='0')end--;
        }

        str[end]='0';
        str[str.length-1]='1';
 return  new String(str);
    }
    public static void main(String[] args) {
     String str="01100110";
        System.out.println("Answer : "+maximumOdd_LogN(str));
    }
}
