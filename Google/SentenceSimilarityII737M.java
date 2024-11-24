package Google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/sentence-similarity-ii/
public class SentenceSimilarityII737M {
    static Map<String, String> parent = new HashMap<>();

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
        // union
        for (List<String> list : similarPairs) {
            union(list.get(0), list.get(1));
        }
        // check union
        for (int i = 0; i < sentence1.length; i++) {
            if (!find(sentence1[i]).equals(find(sentence2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static String find(String str) {
        if (!parent.containsKey(str)) {
            parent.put(str, str);
        }
        if (parent.get(str) != str) {
            parent.put(str, find(parent.get(str)));
        }
        return parent.get(str);
    }

    public static void union(String str1, String str2) {
        String root1 = find(str1);
        String root2 = find(str2);

        if (root1 != root2) {
            parent.put(root1, root2);
        }
    }
}
