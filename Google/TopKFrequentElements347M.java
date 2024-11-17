package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class TopKFrequentElements347M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            queue.add(entry.getKey());
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] ans = new int[k];
        int i=0;
        while (i<k) {
            ans[i]=queue.poll();
            i++;
        }
        return ans;
    }
}
