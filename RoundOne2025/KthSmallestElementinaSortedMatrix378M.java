package RoundOne2025;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/?show=1
public class KthSmallestElementinaSortedMatrix378M {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for(int i=0;i<matrix.length;i++){
            heap.add(new int[]{matrix[i][0],i,0});
        }
        while (k-1>0) {
            int[] cur = heap.poll();
            int row = cur[1],col = cur[2];
            if (col+1<matrix.length) {
                heap.add(new int[]{matrix[row][col+1],row,col+1});
            }
            k--;
        }
        return heap.poll()[0];
    }
}
