package algorithimPatterns.BinarySearch;
public class BinarySearch {

    public static void main(String[] args) {
        int index [] ={0,1,2,3,4,5,6,7,8};
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 5;
      //  System.out.println("")
        System.out.println("Answer : "+binarySearch(arr,target));
    }

    public static int binarySearch(int [] arr , int target){
        int left=0;
        int right=arr.length-1;

        while(left<right){
            int mid = left +(right-left)/2;
            System.out.println("mid : "+mid);
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>=target){
                right=mid;
                System.out.println("right : "+right);
            }else{
                left=mid+1;
                System.out.println("Left : "+left);
            }
        }
        return -1;
    }}
