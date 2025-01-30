package Tiktok2025;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class KthSmallestElementinaSortedMatrix378M {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[] { matrix[i][0], i, 0 });
        }

        while (k - 1 > 0) {
            int[] array = queue.poll();
            int row = array[1], column = array[2];

            if (column + 1 < matrix.length) {
                queue.add(new int[] { matrix[row][column + 1], row, column + 1 });
            }
            k--;
        }
        return queue.poll()[0];
    }
}
