package Array;

//https://leetcode.com/problems/matrix-diagonal-sum/
public class MatrixDiagonalSum1672E {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            int num1 = mat[i][i];
            int num2 = 0;
            if (i != mat[i].length - i - 1) {
                num2 = mat[i][mat[i].length - i - 1];
            }
            ans += num1 + num2;
        }
        return ans;
    }
}
