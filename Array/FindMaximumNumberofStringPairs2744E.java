package Array;

//https://leetcode.com/problems/find-maximum-number-of-string-pairs/
public class FindMaximumNumberofStringPairs2744E {
    public static void main(String[] args) {
        String[] words = { "cd", "ac", "dc", "ca", "zz" };
        System.out.println(maximumNumberOfStringPairs(words));
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        for (String str1 : words) {
            for (String str2 : words) {
                if (str1.equals(str2)) {
                    continue;
                }
                if (str1.charAt(0) == str2.charAt(1) && str1.charAt(1) == str2.charAt(0)) {
                    ans++;
                }
            }
        }
        return ans/2;
    }
}
