package Tiktok2025.SecondRound;

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
        Map<String, String> parentMap = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            union(similarPair.get(0), similarPair.get(1), parentMap);
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (!findParent(sentence1[i], parentMap).equals(findParent(sentence2[i], parentMap))) {
                return false;
            }
        }
        return true;
    }

    public static void union(String str1, String str2, Map<String, String> parentMap) {
        String parent1 = findParent(str1, parentMap);
        String parent2 = findParent(str2, parentMap);
        if (!parent1.equals(parent2)) {
            parentMap.put(parent1, parent2);
        }
    }

    public static String findParent(String str, Map<String, String> parentMap) {
        if (!parentMap.containsKey(str)) {
            parentMap.put(str, str);
        }
        if (!parentMap.get(str).equals(str)) {
            parentMap.put(str, findParent(parentMap.get(str), parentMap));
        }
        return parentMap.get(str);
    }
}
