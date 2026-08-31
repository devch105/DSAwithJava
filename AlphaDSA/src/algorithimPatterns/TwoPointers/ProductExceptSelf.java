package algorithimPatterns.TwoPointers;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
       // productOfArrayExceptItself(arr);
        productExceptSelf(arr);
    }

    public static void productOfArrayExceptItself(int arr[]) {

        int leftProd[] = new int[arr.length];
        int rightProd[] = new int[arr.length];

        leftProd[0] = 1;
        rightProd[arr.length - 1] = 1;

        for (int i = 1; i < arr.length; i++) {
            leftProd[i] = leftProd[i - 1] * arr[i - 1];
        }
        System.out.println("Left product : " + Arrays.toString(leftProd));

        for (int i = arr.length - 2; i >= 0; i--) {
            rightProd[i] = rightProd[i + 1] * arr[i + 1];
        }

        System.out.println("Right Product : " + Arrays.toString(rightProd));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = leftProd[i] * rightProd[i];
        }
        System.out.println("Answer : " + Arrays.toString(arr));
    }

    // another approach using single resultant array
    public static void productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < ans.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        // return ans;
        for (int x : ans) {
            System.out.print(x + ",");
        }
    }
}
