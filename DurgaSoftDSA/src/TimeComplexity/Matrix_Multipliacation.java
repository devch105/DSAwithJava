package TimeComplexity;

public class Matrix_Multipliacation {
    public static int[][] Multiplication_2D(int[][] arr, int[][] brr){
        int[][] C = new int[arr.length][arr.length];
       for(int i=0; i< arr.length; i++){ // n+1
           for(int j=0; j<arr.length; j++){  // n*(n+1)=>n^2
               for (int k=0; k<arr.length; k++){ //  n^2 *(n+1) => n^3
                   C[i][j]+=arr[i][k]*brr[i][k];
               }

           }
       }
        return C;
    }


    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] brr ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] c =Multiplication_2D(arr,brr);
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr.length; j++){
                System.out.print("["+c[i][j]+"]");
            }
            System.out.println();
        }


    }
}
