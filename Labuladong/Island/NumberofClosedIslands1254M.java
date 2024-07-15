package Labuladong.Island;

//https://leetcode.com/problems/number-of-closed-islands/
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
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid);
            dfs(i, n - 1, grid);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, grid);
            dfs(m - 1, j, grid);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
    }
}
