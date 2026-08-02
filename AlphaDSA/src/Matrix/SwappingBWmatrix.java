package Matrix;

import java.util.Scanner;



public class SwappingBWmatrix {
    static void print(int arr[][],int n,int m){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void swappingofRows(int arr[][],int n,int row, int col ,int m ){

             for(int i=0; i<col; i++){
                 int t=arr[m-1][i];
                 arr[m-1][i]=arr[n-1][i];
                 arr[n-1][i]=t;

             }
    }
    static void swappingofcols(int arr[][],int n,int row, int col ,int m ){

        for(int i=0; i<col; i++){
            int t=arr[i][m-1];
            arr[i][m-1]=arr[i][n-1];
            arr[i][n-1]=t;

        }
    }
    static void swappingofdiagonal(int arr[][],int n,int row, int col ,int m ){

        for(int i=0; i<row; i++){
            int t=arr[i][i];
            arr[i][i]=arr[i][row-i-1];
            arr[i][row-i-1]=t;

        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Row size: ");
        int N1=sc.nextInt();
        System.out.println("Enter Column Size :");
        int M1=sc.nextInt();
        int A1[][]=new int [N1][M1];
        System.out.println("Enter Array Elements : ");
        for(int i=0; i<N1; i++){
            for(int j=0; j<M1; j++){
                A1[i][j]=sc.nextInt();
            }
        }
//        System.out.println("---before  row swapping ---");
//        print(A1,N1,M1);
//
//        swappingofRows(A1,2,N1,M1,3);
//
//        System.out.println("-- After row Swapping --");
//        print(A1,N1,M1);
//
//
//        System.out.println("---before col swapping ---");
//        print(A1,N1,M1);
//
//        swappingofcols(A1,2,N1,M1,3);
//
//        System.out.println("-- After col Swapping --");
//        print(A1,N1,M1);
        System.out.println("--swapping Diagonals--");
        print(A1,N1,M1);
        swappingofdiagonal(A1,1,N1,M1,3);
        System.out.println("-- after swapping Diagonals--");
        print(A1,N1,M1);





//        System.out.println("Enter Row size: ");
//        int N2=sc.nextInt();
//        System.out.println("Enter Column Size :");
//        int M2=sc.nextInt();
//        int A2[][]=new int [N1][M1];
//        System.out.println("Enter Array Elements : ");
//        for(int i=0; i<N2; i++){
//            for(int j=0; j<M2; j++){
//                A2[i][j]=sc.nextInt();
//            }
//        }


    }
}


