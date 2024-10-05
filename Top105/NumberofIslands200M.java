package Top105;

// https://leetcode.com/problems/number-of-islands/?envType=study-plan-v2&envId=top-interview-150
public class NumberofIslands200M {
    static boolean flag = false;

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                flag = false;
                calculateIslands(grid, i, j);
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void calculateIslands(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            flag=true;
            grid[i][j] = '0';
            calculateIslands(grid, i - 1, j);
            calculateIslands(grid, i, j - 1);
            calculateIslands(grid, i, j + 1);
            calculateIslands(grid, i + 1, j);
        }
        return;
    }
}
