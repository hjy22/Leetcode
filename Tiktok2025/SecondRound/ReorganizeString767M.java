package Tiktok2025.SecondRound;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767M {
    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        Map<Character, Integer> countTimes = new HashMap<>();
        int maxTimes = 0;
        for (Character c : s.toCharArray()) {
            countTimes.put(c, countTimes.getOrDefault(c, 0) + 1);
            maxTimes = Math.max(maxTimes, countTimes.get(c));
        }
        if (maxTimes > (s.length()+1) / 2) {
            return "";
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });
        queue.addAll(countTimes.entrySet());

        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            Map.Entry<Character, Integer> num1 = queue.poll();
            Map.Entry<Character, Integer> num2 = queue.poll();
            sb.append(num1.getKey());
            sb.append(num2.getKey());

            if (num1.getValue() > 1) {
                num1.setValue(num1.getValue() - 1);
                queue.add(num1);
            }
            if (num2.getValue() > 1) {
                num2.setValue(num2.getValue() - 1);
                queue.add(num2);
            }
        }
        if(queue.size()==1){
            sb.append(queue.poll().getKey());
        }
        return sb.toString();
    }

}
