package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Basic_Operation {
      // Reverse An ArrayList
     static ArrayList<Integer> reverse(ArrayList<Integer> list){
         int strt=0;
         int end=list.size()-1;

         while (strt<=end){
             int temp=list.get(end);
             list.set(end,list.get(strt));
             list.set(strt,temp);
             strt++;
             end--;
         }
     return list;
     }
     // Find Max in ArrayList
     static int FindMax(ArrayList<Integer>list){
         int max=list.get(0);
         for (int i=0; i<list.size(); i++){
             if(max<list.get(i)){
                 max=list.get(i);
             }
         }
         return max;
     }


     // Sort ArrayList

    static ArrayList<Integer> SortList(ArrayList<Integer>list){
        Collections.sort(list);
        return list;
    }


    public static void main(String[] args) {
        ArrayList<Integer> l1=new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(555);
        l1.add(6);
        l1.add(7);
        l1.add(90);
        System.out.println("----------- ");
        System.out.println("Reverse : "+reverse(l1));

        System.out.println("Find Max : "+FindMax(l1));

        System.out.println("Sort : "+SortList(l1));

    }
}
