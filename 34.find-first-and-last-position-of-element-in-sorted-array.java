/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int front = 0, end = nums.length - 1;
        int frontAns = -1, endAns = -1;
        while (front <= end) {
            if (frontAns != -1 && endAns != -1) {
                break;
            }
            if(nums[front]==target){
                frontAns=front;
            }
            if(nums[end]==target){
                endAns=end;
            }
            if (frontAns == -1) {
                front++;
            }
            if (endAns == -1) {
                end--;
            }
        }
        return new int[] { frontAns, endAns };
    }
}
// @lc code=end
