package Tiktok2025.SecondRound;

public class RedundantConnection684M {
    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] ans = findRedundantConnection(edges);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int size = 0;
        for (int[] edge : edges) {
            size = Math.max(edge[0], size);
            size = Math.max(edge[1], size);
        }
        int[] parent = new int[size + 1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for (int[] edge : edges) {
            int root1 = findParent(edge[0], parent);
            int root2 = findParent(edge[1], parent);
            if (root1 == root2) {
                return edge;
            } else {
                parent[root1] = root2;
            }
        }
        return new int[] {};
    }

    public static int findParent(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = findParent(parent[e], parent);
        }
        return parent[e];
    }

}
