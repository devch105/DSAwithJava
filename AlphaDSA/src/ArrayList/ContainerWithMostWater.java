package ArrayList;

import java.util.ArrayList;

public class ContainerWithMostWater {

    static int contains(ArrayList<Integer> l1){
       int most=0;
        for(int i=0; i<l1.size(); i++){
            for (int j=i+1; j<l1.size(); j++){
                int ht=j-i;
                int minwid=Math.min(l1.get(j),l1.get(i));
                most=Math.max(most,(minwid*ht));
            }
        }
        return most;
    }

    // Two Pointer Approcah
    static int OptimizeContains(ArrayList<Integer> l1){
        // Left Pointer
        int i=0;
        // Right Pointer
        int j=l1.size()-1;
        int most=0;
        while (i<=j){
            int ht=Math.min(l1.get(i),l1.get(j));
            int wid=j-i;
            most=Math.max(most,ht*wid);
            if(l1.get(i)<l1.get(j)){
                i++;
            }else{
                j--;
            }
        }
        return most;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(8);
        l1.add(6);
        l1.add(2);
        l1.add(5);
        l1.add(4);
        l1.add(8);
        l1.add(3);
        l1.add(7);

       //  System.out.println("Answer : "+contains(l1));  // Brute force
        System.out.println("Answer : "+OptimizeContains(l1));
    }
}
