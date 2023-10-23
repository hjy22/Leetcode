package array;

//https://leetcode.com/problems/rotate-image/
public class rotateImage48M {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        System.out.println("=======");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix.length];
        int ansColmn = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int ansRow = 0;
            for (int j = 0; j < matrix.length; j++) {
                ans[ansRow][ansColmn] = matrix[i][j];
                ansRow++;
            }
             ansColmn++;
        }

        //restore the value back to the matrix array
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}
