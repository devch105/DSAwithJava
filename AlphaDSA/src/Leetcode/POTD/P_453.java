package POTD;
public class P_453 {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println("Answer : "+minMoves(arr));
    }

    // optimized
    public static  int minMoves(int nums[]){
       int sum=0;
       int min=Integer.MAX_VALUE;
       for(int i=0; i<nums.length; i++){
        sum+=nums[i];
        min=Math.min(min,nums[i]);
       }
       return sum-nums.length*min;
     }

    // Optimized Approach //
    // Decrement max will handle only one element decreasing so will we not needed to work on n-1 elements ?

     public static  int minMove(int arr[]){
        int min = findMin(arr);
        int moves = 0;
        for(int x : arr){
            moves += min;
        }
        return moves;
     }

     public static  int findMin(int arr[]){
        int min = Integer.MAX_VALUE;
        for(int x : arr){
            if(x<min){
                min=x;
            }
        }
        return min;
     }




















    // Brute Force //
    public static  boolean allElementEquals(int nums[]){
        int item = nums[0];
        for(int i=1; i<nums.length; i++){
            if(item!=nums[i]){
                return false;
            }
        }
        return true;
    }
    
    public static int findMaxIndex(int nums[]){
        int index = 0;
        int max=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }

    public static void incrementOtherIndexNumber(int arr[],int indx){
        for(int i=0; i<arr.length; i++){
            if (i!=indx) {
               arr[i]++;
            }
        }
    }
}
