//package Stacks;
//
//import java.util.Stack;
//
//public class BracketBalancing {
//    public static void main(String[] args) {
//       String barkets="}{{}}{{{";
//
//
//    }
//
//    public  static  int countMinimumBracket(char [] arr){
//        Stack<Character> stack=new Stack<>();
//
//        for(int i=0; i<arr.length; i++){
//            if(arr[i]=='{'){
//                stack.push(arr[i]);
//            }else{
//                if(stack.isEmpty() || stack.peek()=='}'){
//                    stack.push(arr[i]);
//                }else {
//                    stack.pop();
//                }
//            }
//        }
//        int ans=0;
//        while (stack.isEmpty()){
//
//        }
//    }
//}
