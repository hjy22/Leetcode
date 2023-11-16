package Graph;

import java.util.*;

public class MinCostConnectM1584Prim {
    public static void main(String[] args) {
        // int[][] points = { { 2, -3 }, { -17, -8 }, { 13, 8 }, { -17, -15 } };
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int sum = 0;
        if (points.length == 1) {
            return 0;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (a.get(2) - b.get(2)));
        boolean[] visit = new boolean[points.length];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        visit[0] = true;
        int count = points.length - 1;
        for (int j = 1; j < points.length; j++) {
            int cost = Math.abs(points[j][0] - points[0][0]) +
                    Math.abs(points[j][1] - points[0][1]);
            List<Integer> zeroDistance = new ArrayList<>();
            zeroDistance.add(0);
            zeroDistance.add(j);
            zeroDistance.add(cost);
            queue.add(zeroDistance);
        }
        while (!queue.isEmpty() && count > 0) {
            List<Integer> temp1 = queue.poll();
            int node = temp1.get(1);
            int cost = temp1.get(2);
            if (!visit[node]) {
                visit[node] = true;
                sum += cost;
                for (int i = 0; i < points.length; i++) {
                    if (visit[node]) {
                        int distance = Math.abs(points[i][0] - points[node][0]) +
                                Math.abs(points[i][1] - points[node][1]);
                        List<Integer> costArray = new ArrayList<>();
                        costArray.add(node);
                        costArray.add(i);
                        costArray.add(distance);
                        queue.add(costArray);
                    }
                }

                count--;
            }

        }
        return sum;
    }

}
