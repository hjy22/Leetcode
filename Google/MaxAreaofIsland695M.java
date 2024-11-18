package Google;

// https://leetcode.com/problems/max-area-of-island/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MaxAreaofIsland695M {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area = calculateArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static int calculateArea(int[][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        return (calculateArea(grid, i-1, j)+calculateArea(grid, i, j-1)+calculateArea(grid, i+1, j)+calculateArea(grid, i, j+1)+1);
    }

}
