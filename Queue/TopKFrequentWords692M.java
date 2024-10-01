package Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords692M {
    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
            (w1, w2) -> map.get(w1).equals(map.get(w2)) ? 
            w2.compareTo(w1) : map.get(w1) - map.get(w2)
        );

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            heap.offer(entry.getKey());
            if(heap.size()>k){
                heap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()){
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
