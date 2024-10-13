package Tiktok;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reorganize-string/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class ReorganizeString767M {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxLen =(s.length()+1)/2;
        for(Character c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c)>maxLen){
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b)->{
            return map.get(b)-map.get(a);
        });
        queue.addAll(map.keySet());
        
        StringBuilder res = new StringBuilder();
        char[] result = new char[s.length()];
        int i = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (int j = 0; j < map.get(c); j++) {
                if (i >= s.length()) i = 1;
                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }
}
