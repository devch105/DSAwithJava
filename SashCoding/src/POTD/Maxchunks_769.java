package POTD;

public class Maxchunks_769 {
    public  static  int maxChunksToSorted(int[] arr) {
           int max=Integer.MIN_VALUE;
           int chunks=0;

           for(int i=0; i< arr.length; i++){
               max=Math.max(max,arr[i]);
               if(max<i+1){
                   chunks++;
               }
           }
     return chunks;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,0,2,3,4};
        System.out.println(" Answer : "+maxChunksToSorted(arr));

    }
}
