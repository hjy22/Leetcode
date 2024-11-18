package Google;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-distinct-islands/
/*在递归中，要用stringbuilder，因为用string会重新创建一个新的对象，导致没有跟着递归一起往下传
传入set的时候，要换回string，不可变
*/
public class NumberofDistinctIslands694M {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, {1, 1, 0, 1, 1 } };
        // int[][] grid= {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(numDistinctIslands(grid));
    }

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder track= new StringBuilder();
                    calShape(grid, i, j, "", track);
                    set.add(track.toString());
                    // System.out.println(track);
                }
            }
        }
        return set.size();
    }

    public static void calShape(int[][] grid, int i, int j,String direction,StringBuilder track) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return ;
        }
        if(grid[i][j]==0){
            return ;
        }

        grid[i][j]=0;
        track.append(direction);
        calShape(grid, i-1,j,"1",track);
        calShape(grid, i,j-1,"2",track);
        calShape(grid, i+1,j,"3",track);
        calShape(grid, i,j+1,"4",track);
        track.append("0");
    }
}
