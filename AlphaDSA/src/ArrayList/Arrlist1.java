package ArrayList;
import java.util.ArrayList;

public class Arrlist1 {

/*

Add                   =    O(1) => list.add(element);
Get                   =    O(1) =>  list.get(index);
Remove Element        =    O(n) => list.remove(i); or list.remove(obj);
Set Element at Index  =    O(n) => list.set(i,obj);
Contains              =    O(n) => list.contains(obj);


 */
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
//        Add
        list.addFirst(3);
        list.add(4);
        list.add(45);
        list.add(23);
//        get
        System.out.println("Get Val : "+list.get(3));

//        remove
        System.out.println("remove : "+list.remove(1));

//        set
        System.out.println("set : "+list.set(1,300));

//        contains
        System.out.println("conatins : "+list.contains(300));


//        printlist
        System.out.println("List : "+list);
    }


}
