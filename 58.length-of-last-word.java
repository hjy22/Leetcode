/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int ans = 0;
        boolean find = false;
        while (index >= 0) {
            if (!find) {
                if (s.charAt(index) != ' ') {
                    find = true;
                }
            }
            if (find) {
                if (s.charAt(index) == ' ') {
                    break;
                } else {
                    ans++;
                }
            }
            index--;
        }
        return ans;
    }
}
// @lc code=end
