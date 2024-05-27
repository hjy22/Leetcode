package PrefixSum;

//https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum1314 {
    public static void main(String[] args) {
        int[][] mat = { {67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int k = 3;
        int[][] ans = matrixBlockSum(mat,k);
        for(int[] list:ans){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] sumMat = new int[mat.length+1][mat[0].length+1];
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i=1;i<=mat.length;i++){
            for(int j=1;j<=mat[0].length;j++){
                sumMat[i][j]=mat[i-1][j-1]+sumMat[i-1][j]+sumMat[i][j-1]-sumMat[i-1][j-1];
            }
        }
        for(int[] list:sumMat){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int row1,row2,col1,col2;
                row1=Math.max(i-k, 0);
                row2=Math.min(i+k, mat.length-1);
                col1=Math.max(j-k, 0);
                col2=Math.min(j+k, mat[0].length-1);
                System.out.println("row1:"+row1+" row2:"+row2+" col1:"+col1+" col2:"+col2);
                ans[i][j]= sumRegion(sumMat, row1, col1, row2, col2);
            }
        }
        return ans;
    }

    public static int sumRegion(int[][] newMatrix, int row1, int col1, int row2, int col2) {
        return newMatrix[row2+1][col2+1]-newMatrix[row1][col2+1]-newMatrix[row2+1][col1]+newMatrix[row1][col1];
    }
}
