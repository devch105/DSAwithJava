package AlgorithimPatterns.TwoPointers;

public class ContainerWithMostWater_P11 {
    static void main() {
        int arr [] ={1,8,6,2,5,4,8,3,7};
        System.out.println("Area : "+mostWater(arr));
    }
    public static int mostWater(int[] arr) {
        int max = 0;
        int left=0;
        int right=arr.length-1;

        while(left<right){
            int height = Math.min(arr[left],arr[right]);

            int breadth = right-left;


            int Area = height*breadth;

            max = Math.max(max,Area);

            System.out.println("height : "+height+" breadth : "+breadth+" Area : "+Area+" max : "+max);
            if(arr[left]<=arr[right]){
                left++;
            }else {
                right--;
            }
        }
        return  max;
    }

}
