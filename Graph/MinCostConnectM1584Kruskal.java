package Graph;

import java.util.*;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostConnectM1584Kruskal {
    public static void main(String[] args) {
        int[][] points = { { -14, -14 }, { -18, 5 }, { 18, -10 }, { 18, 18 }, { 10, -2 } };
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        int ans = 0;
        int length = points.length;
        if (length == 1) {
            return 0;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (a.get(2) - b.get(2)));
        int[] parents = new int[length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Set<Integer> nodeSet = new HashSet<>();
        List<Integer> edgeSet = new ArrayList<>();
        getMinQueue(queue, points);
        // while (!queue.isEmpty()) {
        // System.out.println(queue.poll());
        // }

        while (nodeSet.size() < length || edgeSet.size() < length - 1) {
            List<Integer> temp = queue.poll();
            int sourceNode = temp.get(0);
            int targetNode = temp.get(1);
            int distance = temp.get(2);

            int sourceParent = findParent(parents, sourceNode);
            int targetParent = findParent(parents, targetNode);

            if (sourceParent != targetParent) {
                nodeSet.add(sourceParent);
                nodeSet.add(targetParent);
                edgeSet.add(distance);
            }
            union(parents, sourceNode, targetNode);

        }

        for (Integer item : edgeSet) {
            ans += item;
        }
        return ans;
    }

    private static int findParent(int[] parents, int node) {
        if (parents[node] == node) {
            return node;
        }
        return findParent(parents, parents[node]);
    }

    private static void union(int[] parents, int node1, int node2) {
        int nodeParent1 = findParent(parents, node1);
        int nodeParent2 = findParent(parents, node2);
        parents[nodeParent1] = nodeParent2;
    }

    private static void getMinQueue(PriorityQueue<List<Integer>> queue, int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                list.add(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                queue.add(list);
            }
        }
    }
}
