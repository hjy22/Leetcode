package Google;

// https://leetcode.com/problems/redundant-connection/
public class RedundantConnection684M {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(findRedundantConnection(edges));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        // initialize the set
        int maxLen =0;
        for(int[] edge:edges){
            maxLen =Math.max(edge[0], maxLen);
            maxLen =Math.max(edge[1], maxLen);
        }
        initialize(edges,maxLen);
        // union the root
        for (int[] edge : edges) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 == root2) {
                return edge;
            } else {
                union(root1, root2);
            }
        }
        return new int[]{};
    }


    public static void initialize(int[][] edges,int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int root1, int root2) {
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
