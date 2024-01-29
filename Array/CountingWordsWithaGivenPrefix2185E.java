package Array;

//https://leetcode.com/problems/counting-words-with-a-given-prefix/
public class CountingWordsWithaGivenPrefix2185E {
    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    public static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String str : words) {
            if (str.startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }
}
