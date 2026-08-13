package Graph.Leetcode;

public class P_695 {
    public static void main(String[] args) {

        int grid[][] =

                {
                        { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                        { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
                };

        System.out.println("Maximum Area of Island : " + maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currArea = helper(grid, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }

    public static int helper(int grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;

        int left = helper(grid, i, j - 1);
        int right = helper(grid, i, j + 1);
        int up = helper(grid, i - 1, j);
        int down = helper(grid, i + 1, j);

        return 1 + left + right + up + down;

    }
}
