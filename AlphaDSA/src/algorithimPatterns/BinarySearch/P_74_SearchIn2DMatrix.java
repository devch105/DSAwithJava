package algorithimPatterns.BinarySearch;

public class P_74_SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = searchInMatrix(matrix, target);
        System.out.println("Element found: " + result);
    }

    public static boolean searchInMatrix(int [][] matrix , int target){
    
        if(matrix == null || matrix.length ==0) return false;


        int row = matrix.length;
        int col = matrix[0].length;
        int left =0;
        int right = row*col -1;

        while(left<=right){

            int mid = left + (right -left)/2;

            int midElement = matrix[mid/col][mid%col];

            if(midElement == target)return true;
            else if(midElement < target) left= mid+1;
            else right= mid-1;
        }
        return false;
    }

}
