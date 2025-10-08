package AlgorithimPatterns.TwoPointers_SlidingWindow;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
int arr[]={0,0,1,1,1,2,2,3,3,4};
        System.out.println("Answer :"+removeDuplicates(arr));
    }

    public static int removeDuplicates(int arr[]){
        int i=0;
        int j=1;
        while (j<arr.length){
           if(arr[j]==arr[i]){
               j++;
           }
           else{
               i++;
               arr[i]=arr[j];

           }
        }
    return i+1;
    }
}
