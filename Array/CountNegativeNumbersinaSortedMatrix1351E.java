package Array;

//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
public class CountNegativeNumbersinaSortedMatrix1351E {
    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] arr : grid) {
            for (int i : arr) {
                if (i < 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
