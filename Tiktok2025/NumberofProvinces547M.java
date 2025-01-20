package Tiktok2025;

// https://leetcode.com/problems/number-of-provinces/
public class NumberofProvinces547M {
    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected[0].length];
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            count++;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(i, j, parent)) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public static boolean union(int e1, int e2, int[] parent) {
        int root1 = find(e1, parent);
        int root2 = find(e2, parent);
        if (root1 == root2) {
            return false;
        }
        parent[root1] = root2;
        return true;
    }

    public static int find(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = find(parent[e], parent);
        }
        return parent[e];
    }
}
