package Recursion;

public class CheckSortedArray {
    static boolean sortedY_N(int arr[],int i){
       if(i==arr.length-1){return true;}
        if(arr[i]>arr[i+1]){return false;}
         return sortedY_N(arr,i+1);
    }

    public static void main(String[] args) {
        int arr[]={2,3,4,5,9,8};
        System.out.println("Answer : "+sortedY_N(arr,0));
    }
}
