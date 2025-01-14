package Tiktok2025;

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MinimumSwapstoGroupAll1sTogether1151M {
    public static void main(String[] args) {
        int[] data = { 0, 0, 0, 1, 0 };
        System.out.println(minSwaps(data));
    }

    public static int minSwaps(int[] data) {
        int totalOne = 0;
        for (int i : data) {
            totalOne += i;
        }

        int left = 0, right = 0;
        int curOne = 0, maxLen = 0;
        while (right < data.length) {
            int i1 = data[right];
            if (i1 == 1) {
                curOne++;
            }
            while (right - left >= totalOne) {
                int i2 = data[left];
                if (i2 == 1) {
                    curOne--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, curOne);
            right++;
        }
        return totalOne - maxLen;
    }
}
