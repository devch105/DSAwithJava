package Arrays;

import java.util.Scanner;

public class SimpleSorting {

    static void Basicsort(int arr[]){
        int temp;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int N=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Element :");
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Array Element before sort :");
        for(int c:arr){
            System.out.print( c+" ");
        }
        System.out.println("}");
        Basicsort(arr);
        System.out.println("After Sort:  ");
        for(int c:arr){
            System.out.print( c+" ");
        }
        System.out.println("}");




    }



}
