package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P_1807 {

    public static void main(String[] args) {
        
        String s =  "(name)is(age)yearsold";
        List<List<String>>  knowledge = new ArrayList<>();
        
        List<String> l1 = new ArrayList<>();

        l1.add("name");
        l1.add("bob");
        knowledge.add(l1);
        

         List<String> l2 = new ArrayList<>();

        l2.add("age");
        l2.add("26");
        knowledge.add(l2);

        System.out.println("Answer : "+evaluate(s, knowledge));
       

    }
 
    
    public static  String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        fillHashMap(knowledge,map);
        StringBuilder sb = new StringBuilder();
        boolean mark = false;
       int i=0;
       while(i<s.length()){
           char ch = s.charAt(i);
           if(ch == '('){
            mark = true;
            i++;
            String check = "";
            while(s.charAt(i)!=')'){
                check+=s.charAt(i);
                i++;
            }
                if(map.containsKey(check)){
                    sb.append(map.get(check));
                }else{
                    sb.append("?");
                }

           }else{
             sb.append(ch);
           }
           i++;
       }
       return sb.toString();
    }

    public static  void fillHashMap(List<List<String>> knowledge , HashMap<String , String> map){

        for(List<String> list : knowledge){
            String key = list.get(0);
            String value = list.get(1);
            map.put(key,value);
        }
    }
}

