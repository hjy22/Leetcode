package DP;

import java.util.Arrays;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
public class rangeSumQuery2dImmutable304M {
    public static void main(String[] args) {
        int[][] matrix ={{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] newMatrix = NumMatrix(matrix);
        for(int i=0;i<newMatrix.length;i++){
            for(int j=0;j<newMatrix[i].length;j++){
                System.out.print(newMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(sumRegion(newMatrix, 2, 1, 4, 3));
    }

    public static int[][] NumMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<newMatrix.length;i++){
            for(int j=1;j<newMatrix[i].length;j++){
                newMatrix[i][j]=matrix[i-1][j-1]+newMatrix[i-1][j]+newMatrix[i][j-1]- newMatrix[i-1][j-1];
            }
        }
        return newMatrix;
    }

    public static int sumRegion(int[][] newMatrix, int row1, int col1, int row2, int col2) {
        return newMatrix[row2+1][col2+1]-newMatrix[row1][col2+1]-newMatrix[row2+1][col1]+newMatrix[row1][col1];
    }

}
