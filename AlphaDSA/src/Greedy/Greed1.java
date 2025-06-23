package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greed1 {
    public static void main(String[] args) {
        // Activity Selection
//        int start[]={1,3,0,5,8,5};
//        int end[]={2,4,6,7,9,9};
//        System.out.println("Count---> "+ActivitySelection(start,end));

        // Fractional KnapSack



    }


    //Activity Selection
    public static int ActivitySelection(int arr1[], int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int count=0;
        int activities[][]=new int[n1][3];
        for(int i=0; i<activities.length; i++){
            activities[i][0]=i;
            activities[i][1]=arr1[i];
            activities[i][2]=arr2[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));
        ArrayList<Integer>l1=new ArrayList<>();
        count++;
        l1.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=1; i<n2; i++){
            if(activities[i][1]>=lastEnd){
                count++;
                l1.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }


        System.out.println("->"+l1);
        return count;

    }

    // Fractional KnapSack
    public static int FractionalKnapsack(int value[],int weight[]){
return 0;
    }


}
