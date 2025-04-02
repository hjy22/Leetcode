package Tiktok2025.Tiktok202504;

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
        int m =grid.length,n=grid[0].length;
        for(int i=0;i<grid.length;i++){
            droveIslands(grid, i, 0);
            droveIslands(grid, i, n-1);
        }

        for(int j=0;j<grid[0].length;j++){
            droveIslands(grid, 0, j);
            droveIslands(grid, m-1, j);
        }

        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    count++;
                    droveIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void droveIslands(int[][] grid, int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        droveIslands(grid, i-1, j);
        droveIslands(grid, i, j-1);
        droveIslands(grid, i+1, j);
        droveIslands(grid, i, j+1);
    }
}
