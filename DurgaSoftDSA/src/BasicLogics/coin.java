package BasicLogics;

public class coin {
    public static void main(String[] args) {
        int add=8;
        int bit=0;
        int count=0;
        for(int i=1; i<365; i++ ){
           if(bit==8){
               count+=add;
               bit=0;
           }
            count++;
            bit++;
        }
        System.out.println("Answer ="+count);
    }

}
