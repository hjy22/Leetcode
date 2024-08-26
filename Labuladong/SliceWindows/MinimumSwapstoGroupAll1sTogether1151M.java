package Labuladong.SliceWindows;

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together
public class MinimumSwapstoGroupAll1sTogether1151M {
    // 这题转化成找到数字1最多的滑动窗口
    // 且窗口的长度固定为1的数量
    public static void main(String[] args) {
        int[] data = { 1, 0, 1, 0, 1 };
        System.out.println(minSwaps(data));
    }

    public static int minSwaps(int[] data) {
        // 计算1的数量
        int totalOne = 0;
        for (int i : data) {
            if (i == 1) {
                totalOne++;
            }
        }

        int maxLen = 0;
        int countOne = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                countOne++;
            }

            // 当前索引超过窗口的长度，开始缩小窗口
            if (i >= totalOne) {
                if (data[i - totalOne] == 1) {
                    countOne--;
                }
            }
            maxLen = Math.max(maxLen, countOne);
        }
        return totalOne - maxLen;
    }
}
