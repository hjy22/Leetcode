package Graph;

import java.util.*;
import javafx.util.Pair;

public class NetworkDelayTimeM743 {
    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        networkDelayTime(times, n, k);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (a.get(0) - b.get(0)));
        int[][] vertex = new int[n][3];
        for (int i = 0; i < vertex.length; i++) {
            vertex[i][0] = i + 1;
            vertex[i][1] = Integer.MAX_VALUE;
            vertex[i][2] = 0;
        }
        vertex[k - 1][0] = k;
        vertex[k - 1][1] = 0;
        vertex[k - 1][2] = 0;
        List<Integer> tempList = new ArrayList<>();
        tempList.add(k);
        tempList.add(0);
        queue.add(tempList);

        while (!queue.isEmpty()) {
            List<Integer> getInfo = queue.poll();
            int currentNode = getInfo.get(0);
            int currentWeight = getInfo.get(1);
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == currentNode) {
                    int nextNode = times[i][1];
                    int nextWeight = times[i][2];
                    int sumWeight = currentWeight + nextWeight;
                    if (vertex[nextNode - 1][1] > sumWeight) {
                        vertex[nextNode - 1][1] = sumWeight;
                        vertex[nextNode - 1][2] = currentNode;

                        List<Integer> newList = new ArrayList<>();
                        newList = new ArrayList<>();
                        newList.add(nextNode);
                        newList.add(sumWeight);
                        queue.add(newList);
                    }
                }
            }
            
        }
        printVertx(vertex);
        return getMin(vertex);
    }

    public static void printVertx(int[][] vertex) {
        for (int[] a : vertex) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }
    }

    private static int getMin(int[][] vertex){
        int max=Integer.MIN_VALUE;
        for (int[] a : vertex) {
            if(max<a[1]){
                max = a[1];
            }
        }
        return max;
    }
}
