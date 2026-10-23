package algorithimPatterns.BinarySearch;

public class CuttingWood {


    public static void main(String[] args) {
        
        int heights [] = {2,6,3,8};
        int k = 7;
        System.out.println("Answer : "+cuttingWood(heights, k));

    }
    public static  int cuttingWood(int arr[] , int k){
        int max = 0;
        for(int x: arr){
            max = Math.max(x,max);
        }
        int left =0 , right =max;
        
        while(left < right){
System.out.println("left : "+left+" right : "+right);
            int mid = left+(right-left)/2;
System.out.println("mid : "+mid);
            if(woodCollected(arr, k, mid)){
                left=mid+1;
                System.out.println("Left : "+left);
            }else{
                right=mid-1;
                System.out.println("right : "+right);
            }
        }
        return right;
    }

    public static  boolean woodCollected(int arr[], int k , int H){
        int wood =0;
        for(int x : arr){
            if(x>H){
                wood+=x-H;
            }
        }
        System.out.println("Wood : "+wood+">"+k+" => "+(wood>=k));
        return wood>=k;
    }
}
