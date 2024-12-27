package Arrays;

import java.util.Scanner;

public class Max_Min_In_Array {
    //-->
    static void printMIN_Max(int [] arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int c:arr){
            if(c<min){
                min=c;
            }
        }
        for(int c:arr){
            if(c>max){
                max=c;
            }
        }

        System.out.println("Max : "+max+" and Min :"+min);


    }
    //-->
    static void print(int arr[]){
        System.out.println();
        for(int c: arr){
          System.out.print(c+" ");
      }
        System.out.println();
    }
    // Q1:
    static void replace(int arr[],int target,int newel){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                arr[i]=newel;
            }

        }
    }
    static void replacewithbreak(int arr[],int target,int newel){
            for(int i=0; i<arr.length; i++){
                if(target==arr[i]) {
                    arr[i] = newel;
                    break;
                }
        }
    }
     public static void main(String[] args) {

        int arr[]={12,12,13,12,43,12,32,12,43};
          //   printMIN_Max(arr);
         // Q1 Replace Array Elements

         Scanner sc=new Scanner(System.in);
         System.out.println("before Replacement");
         print(arr);
         System.out.println("Enter element to Change :");
         int target= sc.nextInt();
         System.out.println("Enter new Element : ");
         int newel=sc.nextInt();
         replace(arr,target,newel);
         System.out.println("After Replacment");
         print(arr);
         System.out.println("Replacement With break : ");
         replacewithbreak(arr,target,newel);
         print(arr);




    }
}
