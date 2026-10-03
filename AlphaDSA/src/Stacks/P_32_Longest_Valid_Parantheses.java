public class P_32_Longest_Valid_Parantheses{

    public static void main(String[] args) {
        String s = "(()))(";
        System.out.println("Answer : "+longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
       int open =0;
       int close =0;
       int result =0;

// Left to Right
       for(char ch  : s.toCharArray()){
        if(ch == '('){
            open++;
        }else{
            close++;
        }
        if(close > open ){
            open = 0;
            close = 0;
        }else if(open == close ){
            result = Math.max(result , open+close);
        }
       }

       // Right To Left

       open = 0;
       close = 0;
        for(int i=s.length()-1; i>=0; i--){
             char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else{
                close++;
            }
            if(open > close ){
                open = 0;
                close = 0;
            }else if(open == close ){
                result = Math.max(result , open+close);
            }
       }
       return result;
    }


}