package Tiktok2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/sentence-similarity/
public class SentenceSimilarity734E {
    public static void main(String[] args) {
        String[] sentence1 = { "great", "acting", "skills" }, sentence2 = { "fine", "drama", "talent" };
        List<List<String>> similarPairs = Arrays.asList(
                Arrays.asList("great", "fine"),
                Arrays.asList("drama", "acting"),
                Arrays.asList("skills", "talent"));
        System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> list : similarPairs) {
            map.putIfAbsent(list.get(0), new HashSet<>());
            map.putIfAbsent(list.get(1), new HashSet<>());
            map.get(list.get(0)).add(list.get(1));
            map.get(list.get(1)).add(list.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i])
                    && (!map.containsKey(sentence1[i]) || !map.get(sentence1[i]).contains(sentence2[i]))) {
                return false;
            }
        }
        return true;
    }

}
