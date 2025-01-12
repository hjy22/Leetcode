package Tiktok2025;

// https://leetcode.com/problems/count-sub-islands/
public class CountSubIslands1905M {
    public static void main(String[] args) {
        int[][] grid1 = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 }
        };
        int[][] grid2 = {
                { 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 }
        };
        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    floodIsland(i, j, grid2);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    count++;
                    floodIsland(i, j, grid2);
                }
            }
        }
        return count;
    }

    public static void floodIsland(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        floodIsland(i - 1, j, grid);
        floodIsland(i, j - 1, grid);
        floodIsland(i, j + 1, grid);
        floodIsland(i + 1, j, grid);
    }
}
