package POTD.Feb.Leetcode;

public class P_1542 {
    public  static  int numOfSubarrays(int[] arr) {
        int prefixSum=0;
        int mod=1000000007;
        int oddCount=0;
        int evenCount=1;
        int res=0;
        for(int i=0; i<arr.length; i++){
            prefixSum+=arr[i];
            if(prefixSum%2==0){
                res+=evenCount;
                evenCount++;
            }else {
                oddCount++;
                res+=oddCount;
            }
            res=res%mod;
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,3,5};
        System.out.println("Answer : "+numOfSubarrays(arr));
    }
}
