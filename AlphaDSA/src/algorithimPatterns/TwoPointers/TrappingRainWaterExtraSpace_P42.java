package algorithimPatterns.TwoPointers;

public class TrappingRainWaterExtraSpace_P42 {
    static void main() {

        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("answer : " + trap(arr));
        System.out.println("Answer : "+trapWater(arr));
    }

    public static int trap(int[] height) {
        int leftMax[] = leftMax(height);
        int rightMax[] = rightMax(height);

        int max = 0;

        for (int i = 0; i < height.length; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            max += h;
        }
        return max;
    }

    public static int[] leftMax(int arr[]) {
        int leftMax[] = new int[arr.length];
        leftMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]); // ✅ fix
        }
        return leftMax;
    }

    public static int[] rightMax(int arr[]) {
        int rightMax[] = new int[arr.length];
        rightMax[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]); // ✅ fix
        }
        return rightMax;
    }


// Approach is Similar to Container With Most Water
    public static int trapWater(int[] height) {

     int leftMax=0;
     int rightMax=0;

     int n=  height.length;

     int left=0;
     int right=n-1;

     int totalWater = 0;

     while(left < right){
        leftMax= Math.max(leftMax, height[left]);
        rightMax=Math.max(rightMax,height[right]);

        if(leftMax < rightMax){
            totalWater += leftMax - height[left];
            left++;
        }else{
            totalWater += rightMax - height[right];
            right--;
        }
     }
     return totalWater;
    }

}

