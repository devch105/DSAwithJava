package algorithimPatterns.TwoPointers;

public class BestTimeToBuyandSellStock {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 1 };
        System.out.println("Answer : " + bestTimetobuyandSellstock(arr));
    }

    public static int bestTimetobuyandSellstock(int arr[]) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }
}
