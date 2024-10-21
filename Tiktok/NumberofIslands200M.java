package Tiktok;

// https://leetcode.com/problems/number-of-islands/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class NumberofIslands200M {
   
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    countIslands(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void countIslands(int i,int j,char[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        countIslands(i-1, j, grid);
        countIslands(i, j-1, grid);
        countIslands(i+1, j, grid);
        countIslands(i, j+1, grid);
    }
}