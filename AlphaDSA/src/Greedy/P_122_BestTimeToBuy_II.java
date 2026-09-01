package Greedy;

public class P_122_BestTimeToBuy_II {
    public static void main(String[] args) {
        int arr[] = { 8, 5, 11, 3, 6, 2, 9, 14, 5, 6 };
        System.out.println("Answer : " + bestTimeTobuyandSellstock(arr));
    }

    public static int bestTimeTobuyandSellstock(int arr[]) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                maxProfit += arr[i] - arr[i - 1];
            }
        }
        return maxProfit;
    }
}
