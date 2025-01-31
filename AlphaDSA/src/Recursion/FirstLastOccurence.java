package Recursion;

public class FirstLastOccurence {
    static int firstoccur(int arr[], int key,int index){
        if(index==arr.length-1)
            return -1;
        if(arr[index]==key){return index;}

        return firstoccur(arr,key,index+1);

    }
    static int LastOccurenece(int arr[],int key , int i){
        if(i==arr.length){
            return -1;
        }
        int isfound=LastOccurenece(arr,key,i+1);
        if(isfound==-1 && arr[i]==key){
            return  i;
        }
        return isfound;
    }
    public static void main(String[] args) {
        int arr[]={8,3,2,4,2,6};
        System.out.println("Answer : "+firstoccur(arr,2 ,0));
        System.out.println("Answer : "+LastOccurenece(arr,2,0));

    }
}
