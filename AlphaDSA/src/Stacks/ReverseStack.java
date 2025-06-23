package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void reverseString(String str){
        Stack<Character>s=new Stack<>();
        String result="";
        int len =str.length();
        int index=0;
        while (index<len){
            s.push(str.charAt(index));
            index++;
        }
        while (!s.isEmpty()){
            char c=s.pop();
            result+=c;
        }

        System.out.println("Reverse String : "+result);
    }


    public static void main(String[] args) {

        reverseString("hello World");
    }
}
