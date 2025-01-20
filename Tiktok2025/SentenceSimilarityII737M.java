package Tiktok2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/sentence-similarity-ii/
public class SentenceSimilarityII737M {
    public static void main(String[] args) {
        String[] sentence1 = { "great", "acting", "skills" };
        String[] sentence2 = { "fine", "drama", "talent" };
        List<List<String>> similarPairs = List.of(
                List.of("great", "good"),
                List.of("fine", "good"),
                List.of("drama", "acting"),
                List.of("skills", "talent"));
        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }

    public static boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
            List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, String> list = new HashMap<>();
        for(List<String> similarPair:similarPairs){
            union(similarPair.get(0), similarPair.get(1), list);
        }

        for(int i=0;i<sentence1.length;i++){
            if(!find(sentence1[i], list).equals(find(sentence2[i], list))){
                return false;
            }
        }
        return true;
    }

    public static void union(String str1, String str2, Map<String, String> list) {
        String root1 = find(str1, list);
        String root2 = find(str2, list);
        if(root1.equals(root2)){
            return;
        }
        list.put(root1, root2);
    }

    public static String find(String str, Map<String, String> list){
        if (!list.containsKey(str)) {
            list.put(str, str);
        }
        if(!list.get(str).equals(str)){
            list.put(str, find(list.get(str), list));
        }
        return list.get(str);
    }
}
