package ArrayList;

import java.util.ArrayList;

public class Pairsum_2 {
    static boolean pairsum2(ArrayList<Integer> l1, int target){
        // Find Pivot
        int pivot=-1;
        for(int i=0; i<l1.size(); i++){
            if(l1.get(i)>l1.get(i+1)){ // break
               pivot=i;
               break;
            }
        }

        int n=l1.size();

        int strt=pivot+1;
        int end=pivot;

        while (strt!=end){
            if (l1.get(strt) + l1.get(end) == target){
                return true;
            }
            else if(l1.get(strt) + l1.get(end) < target){
                strt=(strt+1)%n;
            }else {
                end=(n+end-1)%n;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Integer> l1=new ArrayList<>();

        l1.add(11);
        l1.add(15);
        l1.add(6);
        l1.add(8);
        l1.add(9);
        l1.add(10);

        System.out.println("Answer : "+pairsum2(l1,16));

    }
}
