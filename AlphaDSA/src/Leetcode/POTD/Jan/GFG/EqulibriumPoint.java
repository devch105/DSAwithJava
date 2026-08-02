package POTD.Jan.GFG;

public class EqulibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
       int currsum=0;
       int totalsum=0;
       for(int i=0; i<arr.length; i++){
           totalsum+=arr[i];
       }
        System.out.println(totalsum);
       for(int i=0; i<arr.length; i++){
           if(currsum==(totalsum-currsum-arr[i])){
               return i;
           }
           currsum+=arr[i];
       }
    return -1;
    }

    public static void main(String[] args) {
      int   arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Answer : "+findEquilibrium(arr));

    }
}
