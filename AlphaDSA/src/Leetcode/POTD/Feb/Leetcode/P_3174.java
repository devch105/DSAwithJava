package POTD.Feb.Leetcode;

import java.util.Stack;

public class P_3174 {
//    public static String clearDigits(String s) {
//        Stack<Character> stack=new Stack<>();
//        int n=s.length();
//        for(int i=0; i<n; i++){
//            if(!Character.isDigit(s.charAt(i))){
//                stack.push(s.charAt(i));
//            }else {
//                if(!stack.isEmpty()){
//                    stack.pop();
//                }
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        while (!stack.isEmpty()){
//            sb.insert(0,stack.pop());
//        }
//        return sb.toString();
//    }
public static String clearDigits(String s) {
    StringBuilder sb=new StringBuilder();
    int n=s.length();
    for(int i=0; i<n; i++){
        if(!Character.isDigit(s.charAt(i))){
           sb.append(s.charAt(i));
        }else {
            if(sb.length()!=0){
               sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    return sb.toString();
}


    public static void main(String[] args) {
        String str="8a9vcffui9oopl66";
        System.out.println("Answer : "+clearDigits(str));

    }
}
