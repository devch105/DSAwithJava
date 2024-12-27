package Matrix;

import java.util.Scanner;

public class FirstMatrix {
    static void print(int arr[][],int n,int m){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+""+"["+i+","+j+"] ");
            }
            System.out.println();
        }
    }
    static void addition_of_two_matrix(int A[][],int an1,int an2,int B[][],int bn1,int bn2){
        int C[][]=new int[an1][an2];
        if(an1==bn1 && an2==bn2){
            for(int i=0; i<an1; i++){
                for (int j=0; j<an2; j++){
                    C[i][j]=A[i][j]+B[i][j];
                }
            }
        }else {
            System.out.println("not Possible addition");
        }

        print(C,an1,an2);

    }

// Multiplication
    static void Multiplication_of_two_matrix(int A[][],int an1,int an2,int B[][],int bn1,int bn2){
        int C[][]=new int[an1][an2];
        if(an1==bn2){
            for(int i=0; i<an1; i++){
                for (int j=0; j<an2; j++){
                    C[i][j]=A[i][j]*B[i][j];
                }
            }
        }else {
            System.out.println("not Possible addition");
        }
        print(C,an1,an2);

    }

  static int sumofmatrix(int arr[][],int n,int m){
     int sum=0;
      for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              sum+=arr[i][j];
          }
      }
      return sum;
  }

    static void sumofrows_matrix(int arr[][],int n,int m){

        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<m; j++){
                sum+=arr[i][j];
            }
            System.out.println("Row : "+i+" sum : "+sum);

        }

    }


    static void sumofcolumns_matrix(int arr[][],int n,int m){

        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<m; j++){
                sum+=arr[j][i];
            }
            System.out.println("col : "+(i+1)+" sum : "+sum);

        }

    }

    static void transpose_matrix(int arr[][],int n,int m){
       int brr[][]=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                brr[i][j]=arr[j][i];
            }
        }
        print(brr,n,m);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Row size: ");
        int N=sc.nextInt();
        System.out.println("Enter Column Size :");
        int M=sc.nextInt();
        int A[][]=new int [N][M];
        System.out.println("Enter Array Elements : ");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                A[i][j]=sc.nextInt();
            }
        }
//       // print(A,N,M);
//        System.out.println("Enter Row 2 size: ");
//        int N2=sc.nextInt();
//        System.out.println("Enter Column 2 Size :");
//        int M2=sc.nextInt();
//        int A2[][]=new int [N][M];
//        System.out.println("Enter Array 2 Elements : ");
//        for(int i=0; i<N2; i++){
//            for(int j=0; j<M2; j++){
//                A2[i][j]=sc.nextInt();
//            }
//        }
//
//        System.out.println("------Addition--------");
//        addition_of_two_matrix(A,N,M,A2,N2,M2);
//        System.out.println("-------Multipliaction--------");
//        Multiplication_of_two_matrix(A,N,M,A2,N2,M2);
        System.out.println("----matrix-------");
        print(A,N,M);
        System.out.println();
        System.out.println("----------Sum of matrix Element ---------- ");
        System.out.println(" Answer : "+  sumofmatrix(A,N,M));
        System.out.println("--------Sum of Rows in Matrix-------------");
        sumofrows_matrix(A,N,M);
        System.out.println("---------Sum of columns---------");
        sumofcolumns_matrix(A,N,M);
        System.out.println("---------Transpose of Matrix------");
        transpose_matrix(A,N,M);


    }
}
