package POTD.Jan.Leetcode;

import java.util.Scanner;

public class P_1422 {

    public  static  int maxScore(String s) {
        char arr[]=s.toCharArray();
        int sum=0;
        int ones=0;
        int zeros=0;
        for (char c:arr){
            if(c=='1')ones++;
        }

        for(char c:arr){
            if (c=='0')
                zeros++;
            else ones--;

            sum=Math.max(sum,zeros+ones);
        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner sc= new  Scanner(System.in);
       // String s= sc.nextLine();
        System.out.println("Answer : "+maxScore("00111"));

    }
}
