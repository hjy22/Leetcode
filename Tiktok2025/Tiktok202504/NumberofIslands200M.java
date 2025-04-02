package Tiktok2025.Tiktok202504;

// https://leetcode.com/problems/number-of-islands/
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
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    droveIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void droveIslands(char[][] grid, int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        droveIslands(grid, i-1, j);
        droveIslands(grid, i, j-1);
        droveIslands(grid, i+1, j);
        droveIslands(grid, i, j+1);
    }
}
