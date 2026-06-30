package algorithimPatterns.BinarySearch;

public class P_33_SearchInaRotatedSortedArray {

    public static void main(String[] args) {

        int arr [] = {4,5,6,7,0,1,2};

        System.out.println("Answer : "+searchInRotatedSortedArray(arr,0));
    }

    public static int searchInRotatedSortedArray(int arr [] , int target){
         int pivotIndex = findMin(arr);
         int left=0;
         int right=arr.length-1;
         int firsthalf=binarySearch(arr,target,left,pivotIndex-1);
         if(firsthalf!=-1){
            return firsthalf;
         }
         int secondhalf = binarySearch(arr,target,pivotIndex,right);
         if(secondhalf!=-1){
            return secondhalf;
         }

         return -1;
    }
    public static int findMin(int arr []){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid = left+(right-left)/2;

            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }

    public  static int binarySearch(int arr [] , int target, int left , int right){
        while(left<=right){
            int mid=left+(right-left);
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    
}
