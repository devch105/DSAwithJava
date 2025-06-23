package Stacks;

import java.util.Stack;

public class ValidParaenthesis {
    public static   boolean validparenthesis(String st){
        Stack<Character> s=new Stack<>();

        for(int i=0; i<st.length(); i++){
            //push to stack
            char ch=st.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else {
                //pop
                if(s.isEmpty())return false;
                if(ch==')' && s.peek()=='('
                        || ch=='}' && s.peek()=='{'
                        || ch==']' && s.peek()=='['){
                    s.pop();
                }
            }
        }
     return s.isEmpty();
    }
    public static void main(String[] args) {
        String str="[{({()})}]}";
        System.out.println("Is Valid : "+validparenthesis(str));
    }
}
