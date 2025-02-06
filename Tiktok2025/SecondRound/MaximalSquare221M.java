package Tiktok2025.SecondRound;

// https://leetcode.com/problems/maximal-square/description/
public class MaximalSquare221M {
    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxLength = Math.max(maxLength, dp[i][0]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxLength = Math.max(maxLength, dp[0][i]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        System.out.println(maxLength);
        return maxLength * maxLength;
    }
}
