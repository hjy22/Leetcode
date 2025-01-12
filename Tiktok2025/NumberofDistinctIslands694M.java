package Tiktok2025;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-distinct-islands/
public class NumberofDistinctIslands694M {
    public static void main(String[] args) {
        // int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, {1, 1, 0, 1, 1 } };
        int[][] grid= {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(numDistinctIslands(grid));
    }

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder track = new StringBuilder();
                    floodIsland(i, j, grid,"",track);
                    set.add(track.toString());
                }
            }
        }
        return set.size();
    }

    public static void floodIsland(int i, int j, int[][] grid,String direction,StringBuilder track) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        track.append(direction);
        floodIsland(i-1, j, grid,"1",track);
        floodIsland(i, j-1, grid,"2",track);
        floodIsland(i, j+1, grid,"3",track);
        floodIsland(i+1, j, grid,"4",track);
        track.append(",");
    }
}
