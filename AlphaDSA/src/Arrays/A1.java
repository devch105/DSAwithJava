package Arrays;

public class A1 {

    // List All Pair
    static void AllPairs(int arr[]){
        for(int i=0; i<arr.length; i++){

            for(int j=i+1; j<arr.length; j++ ){
                System.out.print("("+arr[i]+","+arr[j]+") ");
            }
            System.out.println();
        }
    }

    // Print Sub Array and sum

    static void SubArraysprint(int[] arr) {
        int ts = 0;

        for (int strt = 0; strt < arr.length; strt++) {
            int sum = 0;
            for (int end = strt; end < arr.length; end++) {
                sum += arr[end]; // Add current element to sum
                ts++;
                // Print subarray
                System.out.print("[");
                for (int i = strt; i <= end; i++) {
                    System.out.print(arr[i]);
                    if (i < end) System.out.print(", ");
                }
                System.out.println("] Sum: " + sum);
            }
        }
        System.out.println("Total Subarrays: " + ts);
    }



    public static void main(String[] args) {
        int arr1[]={4,3,2,8,5};
        // All Pair
        AllPairs(arr1);
        System.out.println("--------------");
        SubArraysprint(arr1);

    }
}
