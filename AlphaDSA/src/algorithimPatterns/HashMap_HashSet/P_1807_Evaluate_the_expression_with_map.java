public class P_1807_Evaluate_the_expression_with_map{

    public static void main(String[] args) {
       // run it later     
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        fillHashMap(knowledge,map);
        StringBuilder sb = new StringBuilder();
       
       int i=0;
       while(i<s.length()){
           char ch = s.charAt(i);
           if(ch == '('){
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

    public void fillHashMap(List<List<String>> knowledge , HashMap<String , String> map){

        for(List<String> list : knowledge){
            String key = list.get(0);
            String value = list.get(1);
            map.put(key,value);
        }
    }

}