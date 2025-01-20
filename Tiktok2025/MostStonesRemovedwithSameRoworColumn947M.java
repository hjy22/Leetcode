package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class MostStonesRemovedwithSameRoworColumn947M {
    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        for (int[] stone : stones) {
            union(stone[0], stone[1], map, rank);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return stones.length - count;
    }

    public static void union(int e1, int e2, Map<Integer, Integer> map, Map<Integer, Integer> rank) {
        int root1 = find(e1, map);
        int root2 = find(e2, map);
        if (root1 == root2) {
            return;
        }
        map.put(root1, map.get(root2));
        rank.put(root2, rank.get(root1));
    }

    public static int find(int e, Map<Integer, Integer> map) {
        if (!map.containsKey(e)) {
            map.put(e, e);
        }
        if (map.get(e) != e) {
            map.put(e, find(map.get(e), map));
        }
        return map.get(e);
    }
}
