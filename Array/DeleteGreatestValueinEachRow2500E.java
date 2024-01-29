package Array;

import java.util.Arrays;

//https://leetcode.com/problems/delete-greatest-value-in-each-row/
public class DeleteGreatestValueinEachRow2500E {
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 4 }, { 3, 3, 1 } };
        System.out.println(deleteGreatestValue(nums));
    }

    public static int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int times = grid[0].length - 1;
        while (times >= 0) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                Arrays.sort(grid[i]);
                max = Math.max(max, grid[i][grid[i].length - 1]);
                grid[i][grid[i].length-1] = -1;
            }
            ans += max;
            times--;
        }
        return ans;
    }
}
