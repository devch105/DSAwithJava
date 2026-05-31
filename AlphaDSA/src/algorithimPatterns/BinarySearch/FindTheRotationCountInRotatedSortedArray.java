package algorithimPatterns.BinarySearch;

public class FindTheRotationCountInRotatedSortedArray {
    public static void main(String [] args){
        int arr [] = {16, 18, 22, 23, 24, 36, 43, 1, 2};
        int result = findRotationCount(arr);
        System.out.println("Rotation count in the rotated sorted array: " + result);
    }

    public static int findRotationCount(int [] arr){
        int left=0;
        int right = arr.length-1;
        while(left<right){

            int mid = left + (right-left)/2;

           if(arr[mid]<=arr[right]){
            right= mid;
           }else{
            left=mid+1;
           }
        }

        return right;
    }
}
