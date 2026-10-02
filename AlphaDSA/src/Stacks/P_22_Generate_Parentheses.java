package   Stacks;

import java.util.ArrayList;
import java.util.List;

public class P_22_Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println("Answers : "+generateParenthesis(3));
    }

    
    static  List<String> list = new ArrayList<>();

    public static  List<String> generateParenthesis(int n) {
    StringBuilder sb =  new StringBuilder();
    solve(n,sb);

    return list;
    }

    public static void solve(int n, StringBuilder sb){
     int len = 2*n;  
     if(len == sb.length()){
        if(isValid(sb.toString())){
            list.add(sb.toString());
        }
        return ;
     }

     sb.append('(');
     solve(n,sb);
     sb.setCharAt(sb.length()-1,')');
     solve(n,sb);
     sb.deleteCharAt(sb.length()-1);

    }

    // for single type of brackets only
    public static boolean isValid(String s){
        int count =0;
        for(char c : s.toCharArray()){
           if(c == '('){
           count++;
           }
           else{
           count--;
                if(count < 0){    // if count get (-neg) means error occur in string return false immidiately ?
                    return false;
                }
           }
           
        }
        return count == 0;
    }

}
