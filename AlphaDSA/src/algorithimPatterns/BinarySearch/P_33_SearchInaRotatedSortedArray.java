package algorithimPatterns.BinarySearch;

public class P_33_SearchInaRotatedSortedArray {

    public static void main(String[] args) {

        int arr [] = {4,5,6,7,0,1,2};

        System.out.println("Answer : "+searchInRotatedSortedArray(arr,0));
    }

    public static int searchInRotatedSortedArray(int arr [] , int target){
        int left =0;
        int right =arr.length-1;

        while(left<=right){
             int mid = left + (right-left)/2;

             if(arr[mid]==target)return mid;
             if(arr[mid]> arr[left]){

                if(target<=arr[mid] && target>=arr[left]){
                    right   = mid-1;
                }else{
                    left=mid+1;
                }

             }else{
                if(target>=arr[mid] && target<=arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
             }
        }
        return -1;
    }

    
    
}
