package Arrays;

public class BuyAndSellStock2 {
    static int maxprofit(int arr[]){
        int bp=Integer.MAX_VALUE;
        int maxPr=0;

        for(int i=0; i<arr.length; i++){
            if(bp<arr[i]){
                int pr=arr[i]-bp;
                maxPr=Math.max(maxPr,pr);
            }else {
                bp=arr[i];
            }
        }
        return maxPr;
    }
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println("Answer : "+maxprofit(arr));
    }
}
