package Graph.Leetcode;

public class P_200 {

    public static void main(String[] args) {
        char grid[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' },
        };

        System.out.println("NO of Island : " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void helper(char grid[][], int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '$';
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
    }

}
