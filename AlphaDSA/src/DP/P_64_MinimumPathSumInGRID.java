package DP;

import java.util.HashMap;

public class P_64_MinimumPathSumInGRID {
    
    public static void main(String[] args) {
        
        int arr [][] = {
               {1,2,3},
               {3,2,1},
               {10,2,1}
        };

        System.out.println("Answer : "+minimumPath(arr));
    }

    public static int minimumPath(int grid[][]){
        HashMap<String,Integer> map = new HashMap<>();
        System.out.println("-----------------------------------------------------------------");
        return  solve(grid, 0, 0, map);
    }

    public static  int solve(int grid[][] , int i , int j , HashMap<String,Integer> map){
       int n = grid.length;
       int m = grid[0].length;

       if(i==n-1 && j==m-1){
        return grid[i][j];
       }

       if(i>=n || j>=m){
        return Integer.MAX_VALUE;
       }

       String key = i+"-"+j;
       
       if(map.containsKey(key)){
        System.out.println("Key found : "+key);
        return map.get(key);
       }

       int down = solve(grid, i+1, j, map);

       System.out.println("|");
       System.out.println("^");
       System.out.println(down);
       int right = solve(grid, i, j+1, map);
       System.out.println("---> : "+right);

       int current = grid[i][j] + Math.min(right,down);

       System.out.println("key : "+key+" -> Curr : "+current);
       map.put(key, current);
       return  map.get(key);
    }
}
