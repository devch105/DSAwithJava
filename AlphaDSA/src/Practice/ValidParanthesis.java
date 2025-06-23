package Practice;

public class ValidParanthesis {
    public static boolean Isvalid(String s){
        int count=0;

        int strt=0;

        while (strt<s.length()){
            if(s.charAt(strt)=='{')count++;
            if(s.charAt(strt)=='}')count--;
            strt++;
        }
      if (count==0){
          return true;}
      else {
          return false;
      }

    }
    public static void main(String[] args) {
        String str="{}{}{{}}{}}";
        System.out.println("Is Valid "+Isvalid(str));
    }
}
