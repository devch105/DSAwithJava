package ArrayList;

import java.util.ArrayList;

public class ArrayList_2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  l2=new ArrayList<>();
        ArrayList<Integer>l1=new ArrayList<>();
        l1.add(34);
        l1.add(13);
        l1.add(368);
        ArrayList<Integer>l3=new ArrayList<>();
        l3.add(34);
        l3.add(363);
        l3.add(36);
        ArrayList<Integer> l4 =new ArrayList<>();
        l4.add(464);
        l4.add(13);
        l4.add(36);
        l2.add(l1);
        l2.add(l3);
        l2.add(l4);
        System.out.println("2D ArrayList : "+l2);

        for(int i=0; i<l2.size(); i++){
            System.out.println("List "+i+" "+l2.get(i));
        }

    }
}
