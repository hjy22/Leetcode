package Tiktok2025;

// https://leetcode.com/problems/maximal-square/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaximalSquare221M {
    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] squareLength = new int[m][n];

        int maxSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    squareLength[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        squareLength[i][j] = 1;
                    } else {
                        squareLength[i][j] = Math.min(Math.min(squareLength[i - 1][j], squareLength[i][j - 1]),
                                squareLength[i - 1][j - 1]) + 1;
                    }

                }
                maxSquare = Math.max(maxSquare, squareLength[i][j]);
            }
        }
        return maxSquare * maxSquare;
    }
}
