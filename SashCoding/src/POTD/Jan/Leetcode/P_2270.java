package POTD.Jan.Leetcode;

public class P_2270 {

    public static  int waysToSplitArray(int[] arr) {
        long leftsum = 0;
        long rightsum = 0;
        int count = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < arr.length; i++) {
            rightsum += arr[i];
        }

        // Iterate through the array to calculate split points
        for (int i = 0; i < arr.length - 1; i++) { // Fix: loop stops at arr.length - 1
            leftsum += arr[i]; // Fix: increment leftsum properly
            rightsum -= arr[i];
            if (leftsum >= rightsum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={10,4,-8,7};

        System.out.println("Answer Ways : "+waysToSplitArray(arr));
    }
}
