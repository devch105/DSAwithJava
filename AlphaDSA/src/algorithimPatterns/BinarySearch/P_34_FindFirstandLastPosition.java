package algorithimPatterns.BinarySearch;

public class P_34_FindFirstandLastPosition {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] result = findFirstAndLastPosition(arr, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] findFirstAndLastPosition(int [] arr, int target){
        int[] result = new int[2];
        result[0] = findFirstPosition(arr, target);
        result[1] = findLastPosition(arr, target);
        return result;
    }

    public static int findFirstPosition(int [] arr , int target){
        int leftMost=-1;
        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;


            if(arr[mid]>target) right=mid-1;
            else if(arr[mid ] <target) left= mid+1;
            else{
                leftMost=mid;
                right=mid-1;
            }
        }
        return leftMost;
    }

      public static int findLastPosition(int [] arr , int target){
        int rightMost=-1;
        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;


            if(arr[mid]>target) right=mid-1;
            else if(arr[mid ] <target) left= mid+1;
            else{
                rightMost=mid;
                left=mid+1;
            }
        }
        return rightMost;
    }
}
