package ArrayList;

import java.util.ArrayList;

public class PairSum_1 {
    // Brute Force
     static boolean pairsum1(ArrayList<Integer> l1, int target){
         int most=0;
         for(int i=0; i<l1.size(); i++){
             for (int j=i+1; j<l1.size(); j++){
                if(l1.get(i)+l1.get(j)==target)return true;
             }
         }
            return false;
     }


     // Optimize : 2 Pointer
    static boolean pairsum2(ArrayList<Integer> l1, int target){
         int strt=0;
         int end=l1.size()-1;

         while (strt<=end){
             if(l1.get(strt)+l1.get(end)==target){
                 System.out.println("Sum : "+l1.get(strt)+","+l1.get(end));
                 return true;
             }
             else if (l1.get(strt)+l1.get(end)<target) {
                 strt++;
             }else {
                 end--;
             }
         }
         return false;
    }



    public static void main(String[] args) {
        ArrayList<Integer>l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        l1.add(9);

        System.out.println("Answer : "+pairsum2(l1,17));
    }


}