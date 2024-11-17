package Google;

// https://leetcode.com/problems/number-of-islands/?envType=company&envId=google&favoriteSlug=google-thirty-days
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
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    findIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void findIslands(char[][] grid, int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';
        findIslands(grid, i-1, j);
        findIslands(grid, i, j-1);
        findIslands(grid, i+1, j);
        findIslands(grid, i, j+1);
    }
}
