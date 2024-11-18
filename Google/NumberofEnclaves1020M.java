package Google;

//https://leetcode.com/problems/number-of-enclaves/
public class NumberofEnclaves1020M {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        for(int i=0;i<grid[0].length;i++){
            droveIslands(grid, 0, i);
            droveIslands(grid, grid.length-1, i);
        }

        for(int i=0;i<grid.length;i++){
            droveIslands(grid, i, 0);
            droveIslands(grid, i, grid[0].length-1);
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void droveIslands(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==0){
            return;
        }

        grid[i][j]=0;
        droveIslands(grid, i-1, j);
        droveIslands(grid, i, j-1);
        droveIslands(grid, i+1, j);
        droveIslands(grid, i, j+1);
    }
}