package AlgorithimPatterns.TwoPointers;

public class BestTimeToBuyandSellStock {
    static void main() {
        int arr [] = {2,4,1};
        System.out.println("Answer : "+bestTimetobuyandSellstock(arr));
    }
    public static int bestTimetobuyandSellstock(int arr[]){
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            // main condition check if price is minimum update it ..
            if(minPrice>arr[i]){
                minPrice=arr[i];
            }else{
                // else calculate its max profit with current index price ;
                maxProfit = Math.max(maxProfit, arr[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
