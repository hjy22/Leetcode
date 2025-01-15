package Tiktok2025;

// https://leetcode.com/problems/longest-common-prefix/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestCommonPrefix14E {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(String str:strs){
            while (str.indexOf(ans)!=0){
                ans = ans.substring(0, ans.length()-1);
            }
        }
        return ans;
    }
}
