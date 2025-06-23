package Backtracking;

public class SudokoSolver {
    static boolean sudokosolver(int sudo[][], int row,int col){
        //base case
        if(row==9 && col==0 ){
            return true;
        }

        // Recursion
        int nextRow=row, nextcol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextcol=0;
        }
        if(sudo[row][col]!=0){
            for(int dig=1; dig<=9; dig++){
                if(isSafe(sudo,row,col,dig)){
                    sudo[row][col]=dig;
                    if(sudokosolver(sudo,nextRow,nextcol)){
                        // Solution Exist
                         return true;
                    }
                    sudo[row][col]=0;
                }
            }
        }
   return false;
    }

    static boolean isSafe(int[][] sudo, int row, int col, int dig) {
        // column
        for(int i=0; i<=8; i++){
            if(sudo[i][col]==dig){
                return false;
            }
        }
        // Row
        for(int j=0; j<=8; j++){
            if(sudo[row][j]==dig){
                return false;
            }
        }

        // Grid
        int strtRow=(row/3)*3;
        int strtCol=(col/3)*3;

        for(int i=strtRow; i<strtRow+3; i++){
            for(int j=strtCol; j<strtCol; j++){
                if(sudo[i][j]==dig){
                    return false;
                }
            }
        }
     return true;
    }



    public static void main(String[] args) {
       int[][] sudoku = {
                {5, 3, 0, 6, 0, 8, 0, 1, 0},
                {0, 7, 0, 1, 0, 5, 3, 0, 0},
                {1, 0, 0, 3, 0, 2, 0, 6, 0},
                {8, 5, 0, 7, 0, 1, 4, 0, 3},
                {4, 0, 0, 8, 5, 0, 7, 0, 1},
                {0, 0, 3, 0, 2, 0, 0, 5, 0},
                {0, 6, 1, 0, 3, 0, 2, 0, 4},
                {2, 8, 0, 4, 0, 9, 0, 0, 0},
                {0, 4, 0, 2, 0, 6, 0, 7, 9}};

       if(sudokosolver(sudoku,0,0)){
           System.out.println("Solution Exit");
           printSudoko(sudoku);
       }else {
           System.out.println("false");
       }
    }

    private static void printSudoko(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
