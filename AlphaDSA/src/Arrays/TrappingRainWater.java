package Arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static int TrappedWater(int arr[]){
        int[] leftAux=new int[arr.length];
        int[] rightAux=new int[arr.length];
        int lmax=0;
        for(int i=0; i<arr.length; i++ ){
            lmax=Math.max(lmax,arr[i]);
            leftAux[i]=lmax;
        }

        int rmax=0;
        for(int j=arr.length-1; j>=0; j--){
            rmax=Math.max(rmax,arr[j]);
            rightAux[j]=rmax;
        }

        int trappedwater=0;
        for(int k=0; k<arr.length; k++){
            int wtlevel=Math.min(leftAux[k],rightAux[k]);
            int tempRes=wtlevel-arr[k];
            if(tempRes>0){
                trappedwater+=tempRes;
            }else{
                continue;
            }

        }
        System.out.println(Arrays.toString(leftAux));
        System.out.println(Arrays.toString(rightAux));
        return trappedwater;
    }
    public static void main(String[] args) {
        int arr[]={4,2,0,6,3,2,5};
        System.out.println("Answer : "+TrappedWater(arr));
    }
}
