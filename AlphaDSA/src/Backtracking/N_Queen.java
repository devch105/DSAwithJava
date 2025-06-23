package Backtracking;

public class N_Queen {

    static  int count=0;

       //  It is  For Count Ways to Solve N Queen =>
//    static void nQueen(char board[][], int row){
//       // base
//        if(row==board.length){
//            count++;
//           // printboard(board);
//            return;
//        }
//        // column - loops
//        for(int j=0; j<board.length; j++){
//            if(isSafe(board,row,j)){
//                board[row][j]='Q';
//                nQueen(board,row+1); // function Call
//                board[row][j]='-';  // BackTrack Step
//            }
//
//        }
//
//    }
    static  boolean nQueensboolean(char board[][], int row){
        // base
        if(row==board.length){
            count++;
            // printboard(board);
            return true;
        }
        // column - loops
        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                if(nQueensboolean(board,row+1))return true; // function Call
                 board[row][j]='-';  // BackTrack Step
            }
        }
        return false;
    }
// Safe Check
    static boolean isSafe(char[][] board, int row, int col) {
          // vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q')return false;
        }
         // diagonal left up
        for(int i=row-1,j=col-1; i>=0&&j>=0;  i--,j--) {
            if(board[i][j]=='Q')return false;
        }
        // diagonal right up
        for(int i=row-1 , j =col+1; i>=0&& j<board.length; i--, j++ ){
            if(board[i][j]=='Q')return false;
        }

        return true;
    }
// print
    static void printboard(char[][] board) {

         System.out.println("---Chess Board-----");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

 // Main
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='-';
            }
        }

    if( nQueensboolean(board,0)){
        System.out.println("Solution is Possible :");
        printboard(board);
        }else {
        System.out.println("Solution is not Possible");
       }
       // System.out.println("Ways to Solve "+n+" Queens => "+count);
    }
}
