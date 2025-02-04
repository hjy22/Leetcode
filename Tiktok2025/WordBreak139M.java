package Tiktok2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class WordBreak139M {
    static boolean found = false;

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        int[] memo = new int[s.length()];
        return dp(s, 0, wordDict, set, memo);
    }

    public static boolean dp(String s, int index, List<String> wordDict, Set<String> set, int[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != 0) {
            return memo[index] == -1 ? false : true;
        }
        for (int i = 1; i+index <= s.length(); i++) {
            String prefix = s.substring(index, index + i);
            if (set.contains(prefix)) {
                boolean sub = dp(s, index + i, wordDict, set, memo);
                if (sub) {
                    memo[index] = 1;
                    return true;
                }
            }
        }
        memo[index] = -1;
        return false;
    }

    public static void backTrack(String s, List<String> wordDict, int i) {
        if (found) {
            return;
        }
        if (i == s.length()) {
            found = true;
            return;
        }

        for (String word : wordDict) {
            int length = word.length();
            if (i + length <= s.length() && s.substring(i, i + length).equals(word)) {
                backTrack(s, wordDict, i + length);
            }
        }
    }

}
