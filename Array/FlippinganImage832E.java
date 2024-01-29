package Array;

//https://leetcode.com/problems/flipping-an-image/
public class FlippinganImage832E {
    public static void main(String[] args) {
        int[][] nums = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        System.out.println(flipAndInvertImage(nums));
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            int rowLength = image[i].length;
            for(int j=0;j<rowLength;j++){
                ans[i][rowLength-j-1] = 1-image[i][j];
            }
        }
        return ans;
    }
}
