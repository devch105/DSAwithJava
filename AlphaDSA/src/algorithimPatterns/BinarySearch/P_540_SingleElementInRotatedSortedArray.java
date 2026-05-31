package algorithimPatterns.BinarySearch;

public class P_540_SingleElementInRotatedSortedArray {
    public static void main(String[] args) {
   	    int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int result = singleNonDuplicate(arr);
        System.out.println("Single element in the rotated sorted array: " + result);
    }

    public static int singleNonDuplicate(int [] arr){
        int left=0;
        int right=arr.length-1;

        while(left<right){

            int mid = left + (right -left)/2;
            boolean isEven = (right - mid) % 2 == 0;
            if(arr[mid]==arr[mid+1]){
                if(isEven) left=mid+2;
                else right=mid-1;
            }else{
                if(isEven){
                   right=mid;
                } 
                else left=mid+2;
            }
 
        }
        return arr[right];
    }
}
