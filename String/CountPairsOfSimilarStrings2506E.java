package String;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/count-pairs-of-similar-strings/
public class CountPairsOfSimilarStrings2506E {
    public static void main(String[] args) {
        String[] words = { "aabb","ab","ba" };
        System.out.println(similarPairs(words));
    }

    public static int similarPairs(String[] words) {
        String[] array = new String[words.length];
        int ans = 0;
        int index = 0;
        for (String str : words) {
            Set<Character> set = new HashSet<>();
            for (Character c : str.toCharArray()) {
                if (!set.contains(c)) {
                    set.add(c);
                }
            }
            String tmp = "";
            for (Character c : set) {
                tmp += c;
            }
            array[index] = tmp;
            index++;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
