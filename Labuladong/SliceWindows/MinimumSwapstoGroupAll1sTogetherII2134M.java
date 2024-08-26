package Labuladong.SliceWindows;

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
public class MinimumSwapstoGroupAll1sTogetherII2134M {
    public static void main(String[] args) {
        int[] data = { 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(minSwaps(data));
    }
    // length = 7
    // 0  1  2  3  4  5  6  7  8  9  10 11 12 13
    // 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0 

    public static int minSwaps(int[] nums) {
        int length=nums.length;
        int totalOne = 0;
        for (int i : nums) {
            if (i == 1) {
                totalOne++;
            }
        }
        int maxLen = 0;
        int currentOne = 0;
        for (int i = 0; i < length * 2; i++) {
            if (nums[i%length] == 1) {
                currentOne++;
            }
            if (i >= totalOne) {
                if (nums[(i - totalOne)%length] == 1) {
                    currentOne--;
                }
            }
            maxLen = Math.max(maxLen, currentOne);
        }
        return totalOne - maxLen;
    }
}
