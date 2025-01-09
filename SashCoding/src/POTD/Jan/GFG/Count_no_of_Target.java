package POTD.Jan.GFG;
import java.util.Arrays;
 // count no of triplets such that sum of two is greater than 3rd elements
public class Count_no_of_Target {
     static int countTriangles(int arr[]) {
         // code here
         Arrays.sort(arr);
         int ans=0;
         for(int i=arr.length-1;i>=0;i--){
             int st=0, end=i-1;
             while(st<end){
                 if(arr[st]+arr[end]>arr[i]){
                     ans+=end-st;
                     end--;
                 }
                 else {
                     st++;
                 }
             }
         }
         return ans;
     }

    public static void main(String[] args) {
        int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Answer : "+countTriangles(arr));
    }
}
