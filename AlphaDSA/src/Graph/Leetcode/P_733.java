package Graph.Leetcode;

import java.util.Arrays;

public class P_733 {

    public static void main(String[] args) {

        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr =1;
        int sc =1;
        int col =2;
        

        int result [][] =floodFill(image, sr, sc, col);
    
        System.out.println(Arrays.toString(image[0]));
        System.out.println(Arrays.toString(image[1]));
        System.out.println(Arrays.toString(image[2]));


    }

     public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
         boolean vis[][]= new boolean[image.length][image[0].length];
         helper(image, sr, sc, color, vis, image[sr][sc]);
         return image;
    }

     public static void  helper( int [][] image, int sr, int sc, int color, boolean vis [][], int orgColor){
     

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length 
                || vis[sr][sc]  || image[sr][sc] !=orgColor
        ){
            return ; 
        }
        
        vis[sr][sc]=true;
        image[sr][sc] = color;

       // left
       helper(image, sr, sc-1, color, vis, orgColor);

       // right
       helper(image, sr, sc+1, color, vis, orgColor);


       // up
       helper(image, sr-1, sc, color, vis, orgColor);


       // down 
       helper(image, sr+1, sc, color, vis, orgColor);

    }

}
