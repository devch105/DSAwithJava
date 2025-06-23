package Divide_Conqueor;

public class RotatedsortArray {

    public static int searchrotated(int arr[],int target,int strt,int end){
        if(strt>=end) {
        return -1;}

            int mid=strt+(end-strt)/2;
            // found
            if(arr[mid]==target)
                return mid;
            // case 1 : Line 1
            if(arr[strt]<=arr[mid]){
                if(arr[strt]<=target && target<=arr[mid]){
                    return searchrotated(arr,target,0,mid-1);
                }else {
                    return searchrotated(arr,target,mid+1,end);
                }
            }
            // Line 2
            else {
                if(arr[mid]<=target && target<=arr[end])
                    return searchrotated(arr,target,mid+1,end);
                return searchrotated(arr,target,strt,mid-1);
            }
        }

    public static void main(String[] args) {
        int arr[]={8,9,10,11,12,13,1,2,3,4,5,6,7};
        System.out.println("Answer : "+searchrotated(arr,4,0,arr.length-1));

    }
}



