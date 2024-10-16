package Tiktok;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class TopKFrequentElements347M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");

        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            return map.get(a)-map.get(b);
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index]=queue.poll();
            index++;
        }
        return ans;
    }
}
