package Tiktok2025;

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
        for (int i = 0; i < grid.length; i++) {
            floodIsland(i, 0, grid);
            floodIsland(i, grid[i].length-1, grid);
        }

        for (int j = 0; j < grid[0].length; j++) {
            floodIsland(0, j, grid);
            floodIsland(grid.length-1, j, grid);
        }

        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    count++;
                    floodIsland(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void floodIsland(int i, int j, int[][] grid) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        floodIsland(i-1, j, grid);
        floodIsland(i, j-1, grid);
        floodIsland(i, j+1, grid);
        floodIsland(i+1, j, grid);
    }
}
