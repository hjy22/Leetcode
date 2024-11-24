package Google;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-provinces/
public class NumberofProvinces547M {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        initialize(n);
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i:parent){
            set.add(find(i));
        }
        return set.size()-1;
    }

    public static void initialize(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public static int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public static void union(int c1, int c2) {
        int root1 = find(c1);
        int root2 = find(c2);

        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }
}
