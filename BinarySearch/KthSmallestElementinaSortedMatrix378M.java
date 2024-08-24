package BinarySearch;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementinaSortedMatrix378M {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = countNum(matrix, mid);
            if (num < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int countNum(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1; // 从最后一行开始
        int col = 0; // 从第一列开始

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // 如果当前元素 <= target, 那么这一列的所有元素也 <= target
                count += row + 1;
                col++;
            } else {
                // 如果当前元素 > target, 那么需要在更小的行中寻找
                row--;
            }
        }
        return count;
    }
}
