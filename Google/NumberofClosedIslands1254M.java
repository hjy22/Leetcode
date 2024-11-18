package Google;

// https://leetcode.com/problems/number-of-closed-islands/
public class NumberofClosedIslands1254M {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            calIslands(grid, i, 0);
            calIslands(grid, i, grid[0].length-1);
        }

        for(int i=0;i<grid[0].length;i++){
            calIslands(grid, 0, i);
            calIslands(grid, grid.length-1, i);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    calIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void calIslands(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return ;
        }
        if(grid[i][j]==1){
            return ;
        }

        grid[i][j]=1;
        calIslands(grid, i-1,j);
        calIslands(grid, i,j-1);
        calIslands(grid, i+1,j);
        calIslands(grid, i,j+1);
    }
}
