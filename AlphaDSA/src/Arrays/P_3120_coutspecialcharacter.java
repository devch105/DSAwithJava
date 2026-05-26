package Arrays;
import java.util.HashSet;
public class P_3120_coutspecialcharacter {

    public static void main(String[] args) {
        String str = "aAA";

        int count = countSpecialCharacters(str);
        System.out.println("Count of special characters: " + count);
    }

    public static int countSpecialCharacters( String str){
        int count =0;
        HashSet<Character> lower= new HashSet<>();
        HashSet<Character> upper= new HashSet<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
          if(ch>='a' && ch<='z'){
               lower.add(ch);
              }else if(ch>='A' && ch<='Z'){
               upper.add(ch);
            }
        }
        for(char ch : lower){
            char upperch = (char) (ch-32);
            if(upper.contains(upperch)){
                count++;
            }
        }
        
        return count;
    }
}
