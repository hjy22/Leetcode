package Google;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class CountSquareSubmatriceswithAllOnes1277M {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 } };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        ans[i][j] = 1;
                    } else {
                        int left = ans[i][j - 1];
                        int leftUp = ans[i - 1][j - 1];
                        int up = ans[i - 1][j];
                        ans[i][j] = min(left, leftUp, up) + 1;
                    }
                    count += ans[i][j];

                }
            }
        }
        return count;
    }

    public static int min(int x, int y, int z) {
        int min = Math.min(x, y);
        return Math.min(z, min);
    }
}
