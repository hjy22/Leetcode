package Tiktok;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-distinct-islands/submissions/1423716305/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class NumberofDistinctIslands694M {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, {
        1, 1, 0, 1, 1 } };
        // int[][] grid = { { 0, 1 } };
        System.out.println(numDistinctIslands(grid));
    }

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                StringBuilder track = new StringBuilder();
                if (grid[i][j] == 1) {
                    backtrack(i, j, grid, 0, track);
                    set.add(track.toString());
                }
            }
        }
        return set.size();
    }

    public static void backtrack(int i, int j, int[][] grid, int direction, StringBuilder track) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        track.append(direction);
        backtrack(i, j - 1, grid, 1, track);
        backtrack(i + 1, j, grid, 2, track);
        backtrack(i, j + 1, grid, 3, track);
        backtrack(i - 1, j, grid, 4, track);
        track.append(",");
    }
}
