
package Google;

// https://leetcode.com/problems/longest-common-prefix/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class LongestCommonPrefix14E {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(String str:strs){
            while (str.indexOf(prefix)!=0) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
