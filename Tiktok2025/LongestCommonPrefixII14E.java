package Tiktok2025;

// https://leetcode.com/problems/longest-common-prefix/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class LongestCommonPrefixII14E {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
