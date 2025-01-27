package Tiktok2025;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestSubstringwithAtLeastKRepeatingCharacters395M {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i <= 26; i++) {
            maxLen = Math.max(maxLen, getLongestString(s, k, i));
        }
        return maxLen;
    }

    public static int getLongestString(String s, int k, int count) {
        int left = 0, right = 0;
        int maxLen = 0;
        int uniqueCount = 0, validCount = 0;
        int[] letter = new int[26];
        while (right < s.length()) {
            char c = s.charAt(right);
            if (letter[c - 'a'] == 0) {
                uniqueCount++;
            }
            letter[c - 'a']++;
            if (letter[c - 'a'] == k) {
                validCount++;
            }
            while (uniqueCount > count) {
                char d = s.charAt(left);
                if (letter[d - 'a'] == k) {
                    validCount--;
                }
                letter[d - 'a']--;
                if (letter[d - 'a'] == 0) {
                    uniqueCount--;
                }
                left++;
            }
            right++;
            if (validCount == uniqueCount && uniqueCount == count) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen;
    }

}
