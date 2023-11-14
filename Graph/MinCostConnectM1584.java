package Graph;

import java.util.*;

//https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCostConnectM1584 {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        // System.out.println(minCostConnectPoints(points));
        // 使用自定义比较器，按照降序排序
        PriorityQueue<Integer> customPriorityQueue = new PriorityQueue<>();
        customPriorityQueue.add(3);
        customPriorityQueue.add(1);
        customPriorityQueue.add(5);
        customPriorityQueue.add(2);
        int i = 4;
        while (i > 0) {
            i--;
            System.out.println("Custom PriorityQueue中的元素：" + customPriorityQueue.poll());
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        List<List<Integer>> distanceArray = buildDistance(points);
        int sum = 0;
        Set<Integer> nodeSet = new HashSet<>();
        int rowIndex = 0;
        int columnNodeIndex = 0;
        int[] temp = new int[2];
        nodeSet.add(rowIndex);
        while (nodeSet.size() < points.length) {
            temp = getMinindex(distanceArray, nodeSet);
            rowIndex = temp[0];
            columnNodeIndex = temp[1];
            while (nodeSet.contains(columnNodeIndex)) {
                distanceArray.get(rowIndex).set(columnNodeIndex, 0);
                temp = getMinindex(distanceArray, nodeSet);
                rowIndex = temp[0];
                columnNodeIndex = temp[1];
            }
            nodeSet.add(columnNodeIndex);
            sum += distanceArray.get(rowIndex).get(columnNodeIndex);
            rowIndex = columnNodeIndex;
        }
        System.out.println(nodeSet);
        return sum;
    }

    private static List<List<Integer>> buildDistance(int[][] points) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < points.length; j++) {
                temp.add(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
            }
            graph.add(temp);
        }
        return graph;
    }

    private static int[] getMinindex(List<List<Integer>> list, Set<Integer> set) {
        int minValue = Integer.MAX_VALUE;
        int[] array = new int[2];
        for (int setIndex : set) {
            for (int i = 0; i < list.get(setIndex).size(); i++) {
                if (list.get(setIndex).get(i) == 0) {
                    continue;
                }

                if (minValue > list.get(setIndex).get(i)) {
                    minValue = list.get(setIndex).get(i);
                    array[0] = setIndex;
                    array[1] = i;
                }
            }
        }
        return array;
    }

}
