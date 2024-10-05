package Top105;

// https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
public class Searcha2DMatrix74M {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int index;
        int left = 0, right = matrix.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            }
        }
        index = left == 0 ? 0 : left - 1;
        left = 0;
        right = matrix[0].length-1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[index][mid] == target) {
                return true;
            } else if (matrix[index][mid] < target) {
                left = mid + 1;
            } else if (matrix[index][mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
